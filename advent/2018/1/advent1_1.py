# from test_set_next_frequency_step import test_set_next_frequency_step_add_one


def set_next_frequency_step(current_val, new_step):
    # print(f'{current_val} + {new_step} = {current_val + new_step}' )
    return current_val + new_step


def get_frequency_changes(filename):
    counter = 0
    frequency = 0
    with open(filename, 'r') as infile:
        for line in infile:
            counter += 1
            frequency = set_next_frequency_step(frequency, int(line))
    return counter, frequency


if __name__ == '__main__':
    result = get_frequency_changes('input.txt')
    print(result[1])
