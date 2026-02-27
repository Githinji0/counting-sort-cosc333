# Counting Sort Algorithm - COSC 333

A high-performance implementation of the Counting Sort algorithm in Java, tested with 10 million elements.

## 📋 Overview

Counting Sort is a **non-comparison based** sorting algorithm that operates by counting the number of objects having distinct key values, then calculating the positions of each object in the output sequence. Unlike comparison-based algorithms (like QuickSort or MergeSort), Counting Sort can achieve linear time complexity under the right conditions.


## ⏱️ Complexity Analysis

### Time Complexity

| Case | Complexity | Explanation |
|------|-----------|-------------|
| **Best Case** | O(n + k) | When the range (k) is small |
| **Average Case** | O(n + k) | Linear time in all cases |
| **Worst Case** | O(n + k) | Linear time in all cases |

Where:
- `n` = number of elements in the input array
- `k` = range of input values (max value - min value + 1)

### Space Complexity

- **Auxiliary Space**: O(k) for the counting array
- **Total Space**: O(n + k) including the output array

### Performance Characteristics

- ✅ **Linear time complexity** when k = O(n)
- ✅ **Stable sorting** - preserves order of equal elements
- ❌ **Space intensive** when k >> n
- ❌ **Limited to integers** or values that can be mapped to integers

## 🚀 Performance Test Results

### Test Configuration

- **Data Size**: 10,000,000 elements (10 million)
- **Value Range**: 0 to 10,000
- **Data Type**: Random integers
- **Hardware**: Modern CPU (results may vary)

### Expected Output

```
======================================================================
COUNTING SORT ALGORITHM - PERFORMANCE TEST
======================================================================

Test: Sorting 10,000,000 random integers
Range: 0 to 10,000
----------------------------------------------------------------------

[1/4] Generating random data...
      Data generation completed in: ~0.3-0.4 seconds

[2/4] Sample of unsorted data (first 20 elements):
      [4903, 1025, 4542, 8591, 3680, 5237, 2009, ...]

[3/4] Sorting data using Counting Sort...
      Sorting completed in: ~0.2-0.3 seconds

[4/4] Verifying sorted data...
      ✓ Verification passed in: ~0.03-0.05 seconds
      ✓ Array is correctly sorted!

      Sample of sorted data (first 20 elements):
      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ...]

      Sample of sorted data (last 20 elements):
      [... , 10000, 10000, 10000, 10000, 10000, 10000]

----------------------------------------------------------------------
PERFORMANCE SUMMARY:
----------------------------------------------------------------------
Data Size:           10,000,000 elements
Value Range:         0 to 10,000
Generation Time:     ~0.339 seconds
Sorting Time:        ~0.246 seconds
Verification Time:   ~0.039 seconds
Total Time:          ~0.624 seconds

Elements per second: ~40,000,000 elements/sec
Memory used (est.):  ~76 MB

======================================================================
TEST COMPLETED SUCCESSFULLY!
======================================================================
```





## 📊 Comparison with Other Algorithms

| Algorithm | Time Complexity | Space Complexity | Stable | In-Place |
|-----------|----------------|------------------|--------|----------|
| **Counting Sort** | O(n + k) | O(k) | ✅ Yes | ❌ No |
| Quick Sort | O(n log n) avg | O(log n) | ❌ No | ✅ Yes |
| Merge Sort | O(n log n) | O(n) | ✅ Yes | ❌ No |
| Heap Sort | O(n log n) | O(1) | ❌ No | ✅ Yes |
| Bubble Sort | O(n²) | O(1) | ✅ Yes | ✅ Yes |

**Last Updated**: February 23, 2026  
**Author**: EB3 /68815/23 WILLIAM GITHINJI
