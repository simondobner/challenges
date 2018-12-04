class FrequencyMonitor:
    def __init__(self, input_file):
        self.input_file = input_file
        self.frequency = 0
        self.seen_frequencies = [self.frequency]
        self.duplicate_frequency = None
        self.frequency_found = False

    def set_next_frequency_step(self, new_step):
        self.frequency += new_step

    def get_frequency_changes(self):

        with open(self.input_file, 'r') as infile:
            for line in infile:
                yield line

    def frequency_processor(self):
        for this_value in self.get_frequency_changes():
            self.frequency = self.frequency + int(this_value)
            if self.frequency not in self.seen_frequencies:
                self.seen_frequencies.append(self.frequency)
            else:
                self.duplicate_frequency = self.frequency
                self.frequency_found = True
                break


if __name__ == '__main__':
    freq_mon = FrequencyMonitor('input.txt')
    while freq_mon.frequency_found is False:
        freq_mon.frequency_processor()
    print(f'Found the duplicate Frequency, it is: {freq_mon.duplicate_frequency}')
