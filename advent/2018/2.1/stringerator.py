import os

# sequences = ['abcde',
#              'fghij',
#              'klmno',
#              'pqrst',
#              'fguij',
#              'axcye',
#              'wvxyz']

sequences = []

with open(str(os.path.dirname(__file__)) + '/input.txt', 'r') as infile:
    for line in infile:
        sequences.append(line)

not_found = True

while not_found and len(sequences) > 1:
    counter = 1
    for x in range(0, len(sequences) - 1):
        count = sum(1 for a, b in zip(sequences[0], sequences[counter]) if a != b)
        print(f'{sequences[0]}:{sequences[counter]}')
        print(count)
        if count == 1:
            not_found = False
            print(set(sequences[0]).intersection(set(sequences[counter])))
            break
        counter += 1
    sequences.pop(0)
