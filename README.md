# NumericalMethods
![Intellij IDEA](https://img.shields.io/badge/Intellij_IDEA-2019.3-fe305e?style=flat&logo=intellij%20idea)
![Kotlin 100%](https://img.shields.io/badge/Kotlin-100%25-f18e33?style=flat&logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/gradle-5.2.1-%2302303A?style=flat&logo=gradle)

All projects are made using Kotlin & Gradle in Intellij IDEA. To run any of it, just sync Gradle project and run `application` task.

### [Lab 1 - Equation solving algorithms](Lab%201)
Solve equation using [Bisection](Lab%201/src/main/kotlin/Bisection.kt), [Newton](Lab%201/src/main/kotlin/Newton.kt) and [Relaxation](Lab%201/src/main/kotlin/Relaxation.kt) methods. Note that these methods find only one result!

To test any of these methods you need to use these functions:

```kotlin
testBisection(function, precision, left bound, right bound)
testNewton(function, derivative, precision, start point)
testRelaxation(function, derivative, precision, left bound, right bound)
```

You also need to specify function itself and it's derivative. Here is quick example:

```kotlin
fun function(x: Double) = x.pow(3) - 8
fun derivative(x: Double): Double = 3 * x * x

testBisection(::function, 5, -10.0, 3.0)
testNewton(::function, ::derivative, 12, 0.3)
testRelaxation(::function, ::derivative, 12, -0.9, 1.0)
```

### [Lab 2 - System of aquations solving algorithms](Lab%202)
Solve system of equations of n variables which is represented using NxN matrix. Implement [Gauss](Lab%202/src/main/kotlin/Gauss.kt), [Jacobi](Lab%202/src/main/kotlin/Jacobi.kt) and [Seidel](Lab%202/src/main/kotlin/Seidel.kt) algorithms.

Actually `testMatrix(matrix: Matrix, name: String)` method will test all three of these methods. You just need to generate matrices.

```kotlin
// Tests completely random matrix
val random = Matrix(5)
random.generateRandom()
testMatrix(random, "RANDOM")

// Tests diagonally dominant matrix
val ok = Matrix(5)
ok.generateOk()
testMatrix(ok, "OK")

// Tests Hilbert random matrix
val notok = Matrix(5)
notok.generateNotOk()
testMatrix(notok, "NOT OK")
```

### [Lab 3 - PageRank (Simplified)](Lab%203)
Implement simplified [PageRank](Lab%203/src/main/kotlin/PageRank.kt) algirithm.

To test algorithm just use `PageRank` class, which takes number of elements and data file location as constructor parameters. `ELEMENTS` is total number of pages. You can change it in  [`Consts.kt`](Lab%203/src/main/kotlin/Consts.kt) file.

```kotlin
val rank = PageRank(ELEMENTS, "./src/main/kotlin/data.dat")
rank.printRanks()
rank.printMax()
```

data.dat contains `ELEMENTS` number of rows. The first number in each row is an id of page from where there is a link. The other numbers represent ids of to where there is a link from given page:
```
0 1 2 3
1 2 3
2 0
3 0 2
```

### [Lab 4 - System of aquations solving algorithms using Matrix operations](Lab%204)
Solve system of equations of n variables which is represented using NxN matrix. Implement [Gauss](Lab%204/src/main/kotlin/Gauss.kt), [Jacobi](Lab%204/src/main/kotlin/Jacobi.kt) and [Seidel](Lab%204/src/main/kotlin/Seidel.kt) algorithms. Use matrix operations.

First of all you need to generate matrix and b vector:

```kotlin
val matrix = Matrix(3)
val b = doubleArrayOf(1.0, 6.0, 4.0)
val x = doubleArrayOf(1.0, 5.0, 1.0)
matrix.generateOk()
matrix.regenerateWithResult(x, b)
```

You can also set your own matrix insted of random diagonally dominant matrix:

```kotlin
matrix.setElements(
    1, 1, 1,
    4, 3, -1,
    3, 5, 3
)
```

Any of rows gives you an array of results for each variable. Pass it as a `print()` parameter to see the result.

```kotlin
Gauss.solve(matrix, b)
Jacobi.solve(matrix, b)
Seidel.solve(matrix, b)
```

### [Lab 5 - Eigen values and eigen vectors of matrix](Lab%205)
Find eigen values and eigen vectors of matrix.

First of all you need to generate symmetric matrix:

```kotlin
val matrix = Matrix(5)
matrix.generateSymmetric()
```

Then you can find eigen values and eigen vectors using [`Solver`](Lab%205/src/main/kotlin/Solver.kt) class. To get values use `.values` and `.vectors` fields of `Solver` class instance:

```kotlin
val solver = Solver()
solver.solve(matrix)
print(solver.values)
print(solver.vectors)
```

### [Lab 6 - Visualization of Kaczmarz algorithm](Lab%206)
Visualize Kaczmarz algorithm in 2D space.

First of all you need to create two lines and starting point:

```kotlin
val firstLine = Line(1.0, 5.0, 5.0)
val secondLine = Line(1.5, 1.0, -1.0)
val startPoint = Dot(5.0, -5.0)
```

Then to solve you need to use [`Solver`](Lab%206/src/main/kotlin/Solver.kt) class:

```kotlin
val solver = Solver(
    firstLine,
    secondLine,
    startPoint
)

val res = solver.getRes()
val dots = solver.getDots()
```

To print just use:

```kotlin
Visualizer.draw(firstLine, secondLine, res, dots)
```

Example result:
![Example](Lab%206/example.png)

### [Lab 7 - interpolation](Lab%207)
I have no clue what is going here. :confused: