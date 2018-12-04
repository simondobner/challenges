import os


class Fabricator:
    def __init__(self):
        self.fabric = [[0 for x in range(1000)] for y in range(1000)]

        # print(self.fabric)

    def add_claim(self, claim):
        across, down = claim.split()[2].replace(':', '').split(',')
        wide, deep = claim.split()[3].split('x')

        down, wide, across, deep = int(down), int(wide), int(across), int(deep)

        for down_counter in range(down, down + deep):
            for across_counter in range(across, across + wide):
                self.fabric[down_counter][across_counter] += 1

    def get_overlap_count(self):
        count = 0
        for row in self.fabric:
            count += len([1 for i in row if i > 1])

        return count


if __name__ == '__main__':
    fabric = Fabricator()
    with open(str(os.path.dirname(__file__)) + '/input.txt', 'r') as infile:
        for line in infile:
            fabric.add_claim(line)
    print(f'Overlap Counts is: {fabric.get_overlap_count()}')
