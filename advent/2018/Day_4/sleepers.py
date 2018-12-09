import os


class Sleepers:
    def __init__(self):
        self.sleep_log = []
        self.current_guard: int = None
        self.guard_last_state_change_time: int = None
        self.sleep_times = {}
        self.sleepiest_guard = None
        self.most_slept_minute: int = 0

    def load_sleeptime(self, file_name):

        with open(file_name, 'r') as infile:
            for line in infile:
                self.sleep_log.append(line)
        self.sleep_log.sort()

    def create_sleep_time_log(self):

        fell_asleep_at = 0
        for sleeptime in self.sleep_log:
            minute = self.extract_minutes(sleeptime)
            if '#' in sleeptime:
                self.change_the_guard(sleeptime)
            elif 'falls asleep' in sleeptime:
                fell_asleep_at = minute
            elif 'wakes up' in sleeptime:
                woke_up_at = minute
                for sleep_minute in range(fell_asleep_at, woke_up_at):
                    self.sleep_times[self.current_guard].append(sleep_minute)

    @staticmethod
    def extract_minutes(record):
        return int(record[15:17])

    @staticmethod
    def extract_day(record):
        return int(record[10:12])

    def change_the_guard(self, record):
        guard = record.split('#')[1].split(' ')[0]
        if guard not in self.sleep_times:
            self.sleep_times[guard] = []
        self.current_guard = guard

    def get_most_sleepy_guard(self):
        # TODO map, filter, something
        most_minutes = 0

        for guard in self.sleep_times:
            if len(self.sleep_times[guard]) > most_minutes:
                most_minutes = len(self.sleep_times[guard])
                self.sleepiest_guard = guard

    def get_most_slept_minute(self):
        self.most_slept_minute = max(self.sleep_times[self.sleepiest_guard],
                                     key=self.sleep_times[self.sleepiest_guard].count)


if __name__ == '__main__':
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/input.txt')
    guards.create_sleep_time_log()
    guards.get_most_sleepy_guard()
    guards.get_most_slept_minute()

    print(f'guard = {guards.sleepiest_guard }')
    print(f'minute = { guards.most_slept_minute}')
    print(f'result = {int(guards.sleepiest_guard) * int(guards.most_slept_minute)}')
