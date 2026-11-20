import {add, subtract, multiply, divide, square} from './math';

describe('Math utility testing', () => {
  test('add function should return the sum of two numbers', () => {
    expect(add(2, 3)).toBe(5);
  });

  test('subtract function should return the difference of two numbers', () => {
    expect(subtract(5, 3)).toBe(2);
  });

  test('multiply function should return the product of two numbers', () => {
    expect(multiply(2, 3)).toBe(6);
  });

  test('divide function should return the quotient of two numbers', () => {
    expect(divide(6, 2)).toBe(3);
  });

  test('divide function should throw an error when dividing by zero', () => {
    expect(() => divide(6, 0)).toThrow("Cannot divide by zero");
  });

  test('square function should return the square of a number', () => {
    expect(square(3)).toBe(9);
  });
});