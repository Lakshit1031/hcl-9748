import {greet} from '../app.js';
import {test} from 'node:test';
import assert from 'node:assert';

test('greet function should return a greeting message', () => {
  const result = "Hello, world";
  const actual = greet("World");
  assert.strictEqual(actual, result);
});