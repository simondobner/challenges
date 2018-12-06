import os

from sleepers import Sleepers


def test_load_sleeptime():
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    assert guards.current_guard == 99


def test_extract_mintues():
    guards = Sleepers()
    minutes = guards.extract_minutes('[1518-11-04 00:36] falls asleep')
    assert minutes == 36


def test_extract_guard():
    guards = Sleepers()
    guards.change_the_guard('[1518-11-01 00:00] Guard #10 begins shift')
    assert guards.current_guard == '10'
