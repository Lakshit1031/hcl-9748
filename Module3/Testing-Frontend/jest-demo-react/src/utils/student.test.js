import { isEligible } from './student';

describe('Student utility functions', () => {

  test('should return true for attendance >= 75', () => {
    expect(isEligible(75)).toBe(true);
  });

  test('should return false for attendance < 75', () => {
    expect(isEligible(74)).toBe(false);
  });

  test('should throw error for invalid attendance percentage', () => {
    expect(() => isEligible(-1))
      .toThrow("Invalid attendance percentage");

    expect(() => isEligible(101))
      .toThrow("Invalid attendance percentage");
  });

});