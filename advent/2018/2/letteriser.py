import os


class Letteriser():
    def __init__(self, in_file=None):
        self.input_file = in_file
        self.letter_count_list = []
        self.letter_list = ['a', 'b', 'c', 'd', 'e', 'f', 'g',
                            'h', 'i', 'j', 'k', 'l', 'm', 'n',
                            'o', 'p', 'q', 'r', 's', 't', 'u',
                            'v', 'w', 'x', 'y', 'z']

    def get_letter_counts(self, letters):

        count_list = []
        for letter in self.letter_list:
            count = letters.count(letter)
            if count == 2:
                count_list.append(count)
            elif count == 3:
                count_list.append(count)
        self.letter_count_list.append(set(count_list))

    def get_checksum(self):
        flat_list = [item for sublist in self.letter_count_list for item in sublist]
        return flat_list.count(2) * flat_list.count(3)

    def process_input_records(self):
        with open(self.input_file, 'r') as infile:
            for line in infile:
                self.get_letter_counts(line)


if __name__ == '__main__':
    letteriser = Letteriser(str(os.path.dirname(__file__)) + '/input.txt')
    letteriser.process_input_records()
    print(f'result = {letteriser.get_checksum()}')
