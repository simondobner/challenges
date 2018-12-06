class Sleepers:
    def __init__(self):
        self.sleep_log = {}
        self.current_guard: int = None
        self.guard_last_state_change_time: int = None

    def load_sleeptime(self, file_name):
        with open(file_name, 'r') as infile:
            for line in infile:
                minute = self.extract_minutes(line)
                if '#' in line:
                    self.change_the_guard(line)
                    self.guard_last_state_change_time = 0
                elif 'falls asleep' in line:
                    print(f'guard {self.current_guard} fell_asleep at {minute}')
                    for minutes in range(self.guard_last_state_change_time, minute):
                        print(f'Awake at {minutes}')
                    self.guard_last_state_change_time = minute
                elif 'wakes up' in line:
                    print(f'guard {self.current_guard} woke up at at {minute}')
                    for minutes in range(self.guard_last_state_change_time, minute):
                        print(f'Asleep at {minutes}')
                    self.guard_last_state_change_time = minute

    def extract_minutes(self, record):
        # [1518-11-01 00:00] Guard #10 begins shift
        return int(record[15:17])

    def change_the_guard(self, record):
        # [1518-11-01 00:00] Guard #10 begins shift
        self.current_guard = record.split('#')[1].split(' ')[0]
