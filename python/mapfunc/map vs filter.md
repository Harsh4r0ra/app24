In Python, both `map()` and `filter()` are built-in functions that operate on iterables like lists, tuples, or sets. However, they serve different purposes:

### 1. **`map()` Function**:
   - **Purpose**: Transforms each item in an iterable by applying a given function.
   - **Behavior**: It applies a specified function to every item of an iterable (such as a list) and returns a map object (an iterator) of the results.
   - **Syntax**:
     ```python
     map(function, iterable)
     ```
   - **Example**:
     ```python
     numbers = [1, 2, 3, 4]
     result = map(lambda x: x * 2, numbers)
     print(list(result))  # Output: [2, 4, 6, 8]
     ```
   - **Key Point**: `map()` is for transforming or changing the data, and it processes every element of the iterable.

### 2. **`filter()` Function**:
   - **Purpose**: Filters items in an iterable based on a condition.
   - **Behavior**: It applies a specified function (which returns either `True` or `False`) to each item in an iterable and returns only those items for which the function returns `True`.
   - **Syntax**:
     ```python
     filter(function, iterable)
     ```
   - **Example**:
     ```python
     numbers = [1, 2, 3, 4]
     result = filter(lambda x: x % 2 == 0, numbers)
     print(list(result))  # Output: [2, 4]
     ```
   - **Key Point**: `filter()` is for selecting certain elements based on a condition and it returns only the elements that satisfy the condition.

### Summary:
- `map()` transforms or changes each element in the iterable.
- `filter()` selects only the elements that meet a specified condition.

Both functions return iterators, so you often need to wrap them with `list()` to see the output in list form.