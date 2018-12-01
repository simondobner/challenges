import os

from advent1_1 import set_next_frequency_step, get_frequency_changes


def test_set_next_frequency_step_add_one():
    """
    +1, +1, +1 results in  3
    +1, +1, -2 results in  0
    -1, -2, -3 results in -6

    :return:
    """

    frequency = 0
    frequency = set_next_frequency_step(frequency, 1)
    frequency = set_next_frequency_step(frequency, 1)
    frequency = set_next_frequency_step(frequency, 1)
    assert frequency == 3

    frequency = 0
    frequency = set_next_frequency_step(frequency, 1)
    frequency = set_next_frequency_step(frequency, 1)
    frequency = set_next_frequency_step(frequency, -2)
    assert frequency == 0

    frequency = 0
    frequency = set_next_frequency_step(frequency, -1)
    frequency = set_next_frequency_step(frequency, -2)
    frequency = set_next_frequency_step(frequency, -3)
    assert frequency == -6


def test_get_frequency_changes():
    input_file = str(os.path.dirname(__file__)) + '/resources/test_input.txt'
    print(f'infile::::::::::::{input_file}')
    record_count = get_frequency_changes(input_file)
    assert record_count == 10
