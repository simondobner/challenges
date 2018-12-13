import os


class PolymerReactor:
    def __init__(self, input_file: str = None):

        self.polymerised_string: str = None
        if input_file is None:
            input_file = '/test/resources/test_input.txt'

        with open(str(os.path.dirname(__file__)) + input_file, 'r') as infile:
            for line in infile:
                self.polymer = line
        print(f' len is {len(self.polymer)}')

    def react_polymer(self):

        before_string = None
        after_string = self.polymer

        while before_string != after_string:
            before_string = after_string
            for p in range(0, 26):
                after_string = after_string.replace(chr(ord('a') + p) + chr(ord('A') + p), '')
                after_string = after_string.replace(chr(ord('A') + p) + chr(ord('a') + p), '')

            self.polymerised_string = after_string


if __name__ == '__main__':
    polymer = PolymerReactor('/input.txt')
    polymer.react_polymer()
    print(''.join(polymer.polymerised_string))
    print(f'Units remaining is: {len(polymer.polymerised_string)}')
