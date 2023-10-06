# `String` Methods

The `String` class is a great example of a useful component of Java that is not a part of the very base of the language. Classes like `String` are available because they are a part of **Application Program Interfaces** (**API**s) and **libraries**. These are collections of classes that are bundled together to provide functionality. In Java, classes from APIs and libraries are grouped into **packages** that we can use. While `String` is not in the very base of Java, it is in the `Java.lang` package, which is available by default in Java, giving us access to it.

---

## Object `toString` Methods

Every object has a default process for describing itself, which we call its `toString` method. We've actually used this already without realizing, since an object's `toString` method is called automatically when it detects that it needs to be a `String`, namely when we try to print an object or concatenate it with a `String`. Here is an example from `NotesToString1.java` file:

```java
Person person1 = new Person(25);
System.out.println(person1);

String string1 = "This person is " + person1;
System.out.println(string1);
```

This produces the following output:

```
Person@2f92e0f4
This person is Person@2f92e0f4
```

We can see here that both calling a `Person` object in a print statement and concatenating it with a `String` produces the same result, a `String` that says `ObjectType@MemoryLocation`. Any class will do this by default for a `toString` method, but can replace the behavior by writing their own `toString` method. Here is an example `toString` method from the `Person.java` file:

```java
public String toString(){
    return age + " years old";
}
```

This method just returns a `String` with whatever information we want. Now, running the exact same code from `NotesToString1.java` produces a different result:

```
25 years old
This person is 25 years old
```

When we write classes, we will often craft a `toString` method to meet our needs for when our object needs to be described in a `String`!

---

## `String` Length and Indexing

Since `String` objects are really just an ordered set of characters, we will often consider its **length**, which is defined as the number of characters in a `String`. We can always get this value by using the `length` method available to `String` objects. You can call this on a `String` variable or even on a `String` literal if needed. Here is an example from the `NotesLength1.java` file:

```java
String string1 = "Hello, World!";
System.out.println(string1 + " has " + string1.length() + " characters.");

System.out.println("Hello, World! has " + "Hello, World!".length() + " characters.");
```

This produces the following output:

```
Hello, World! has 13 characters.
Hello, World! has 13 characters.
```

The `length` method is a non-void (specifically `int`) that will return an `int` value representing the number of characters in a `String`. Since we assign a number to represent a `String` in the form of its length, we also assign numbers to each individual character to keep track of them, referred to **indexing** (akin to every library book having an assigned number).

Indexes for a `String` start at the number `0` and count up, which we refer to as **0 indexing**. Let's take the `String` `"Hello, World!"` as an example. The first index is `0`, which refers to the first character of the `String`, which is `H`. The next index would be `1`, referring to the second character which is `e`, and so on. Here is the whole `String` numbered with an index:

```
"  H  e  l  l  o  ,     W  o  r  l  d  !  "
   0  1  2  3  4  5  6  7  8  9  10 11 12
```

Some important things to note about indexing:
- Every character counts, even punctuation symbols and spaces!
- The double quotes that outline a `String` do not count.
- The length was `13`, but the final index is `12` because we started at `0`, so we are one behind. This will always be the case and the last index will be `length - 1`.
- Attempting to access an index that is not between `0` and `length - 1` will result in a `StringIndexOutOfBoundsException`.

---

## `String` `substring` Methods

Given a `String`, we might often find ourselves just wanting a portion of the `String`, which would be referred to as a `substring`. To get a piece of a `String`, we use the `substring` method, which is **overloaded**. As a reminder, when a method like `substring` is overloaded, it means it must share its name with another method that has a different parameter list. The first version is the most powerful, taking two `int` arguments as parameters, the first representing a starting point and the second representing an ending point. Here is an example of this version of `substring` in action from the `NotesSubstring1.java` file:

```java
String string1 = "Hello, World!";
System.out.println(string1.substring(5, 10));
```

This will produce the following output:

```
, Wor
```

There is an interesting fact to observe here though, which is we wanted the characters indexed 5 to 10, and we only got the characters indexed 5 to 9. The second parameter as the ending value is gone up to, but explicitly not included, while the starting value is explicitly included. This means that if we want to get just a single character, like say the comma `,` at index `5`, we would need to start at `5`, and end at `6`. Since it will stop before `6`, it will only get our character at index `5`. Here is what this would look like from the `NotesSubstring2.java` file:

```java
String string1 = "Hello, World!";
System.out.println(string1.substring(5, 6));
```

This produces the following output:

```
,
```

This version of the `substring` method because we can get as much of or as little of our `String` as we want. We have a less powerful version of `substring` that just takes in one `int` argument as a parameter, just a starting index. This method will give us the substring that goes from the starting index to the end of the `String`, which can sometimes be easier to use. Here is example of just printing out the `"World!"` from `"Hello, World!"` by starting at the index of `"W"`, which is 7 from the `NotesSubstring3.java` file:

```java
String string1 = "Hello, World!";
System.out.println(string1.substring(7));
```

This produces the following output:

```
World!
```

It is really important to understand what this version of the `substring` method is doing in the background, as we could have just done this ourselves if we wanted. When we call this version of substring like `substring(7)`, it just translates it to a different call `substring(7, length)` and uses our original, more powerful, `substring` method. Since it stops before the ending index, this would really go from indices `7` to `length - 1`, and we know that `length - 1` will always be the last index in a `String`.

---

## `String` `indexOf` Method

Sometimes we might have a `String` and wonder where a particular character or substring appears in it, if it does at all. The `indexOf` method is the built-in way to accomplish this. The `indexOf` method takes a single parameter, a `String` to look for, and its return type is an `int`, which it intends to return the index of the `String` you are looking for in the `String` you are searching in. If it does not find the `String` you are looking for, it will return `-1` (this is specifically chosen as a value that could not have been an index, and so obviously means that it did not find it even though it's still a number). Here is an example of this from the `NotesIndexOf1.java` file:

```java
String string1 = "Hello, World!";
System.out.println(string1.indexOf("ell"));
System.out.println(string1.indexOf(" "));
System.out.println(string1.indexOf("Z"));
```

This produces the following output:

```
1
6
-1
```

As you can see, we can search for a set of characters like `"ell"`, or we can search for an individual character of any kind, like a space `" "`. When we search for something that is not there, we get -1.

A common use for the `indexOf` method is to use it conjunction with the `substring` method to get dynamic substrings. For example, if I wanted all the characters after the first space, I could do this example from the `NotesIndexOf2.java` file:

```java
String string1 = "Hello, World!";
System.out.println(string1.substring(string1.indexOf(" ") + 1));
```

This produces the following output:

```
World!
```

Let's break down how this was determined. When the computer tries to run the print statement, it first has to process the `substring` method, and in order to process the `substring` method, it has to figure out the `indexOf` method. So first thing is `string1.indexOf(" ")`, which based on our `String` we know should be the number `6`. The reason we add 1 is because if we want every character *after* the space, we need to start with the first character after the space, which is the space's `index + 1`. Adding the `1`, we get `7`, so now we call `string1.substring(7)`, which we know from earlier is equivalent to `string1.substring(7, length)`, and therefore will get the substring `"World!"` to print out.

---

## `String` `equals` and `compareTo` Methods

Often we will want to be able to compare two `String` objects, to check if they are the same or different. To do that, we have two different methods to help check how similar or different two `String` objects are. The first method is the `equals` method, which conveniently, is a `boolean` method that just checks if two `String` objects are the same or not. If they are the same, it returns `true`, and if they are not, it returns `false`. `equals` is a `String` method, which means we call it on one of the `String` objects we want to check with the dot operator `.` and pass the other `String` object we want to check as the parameter. Here are a couple of examples from the `NotesEquals1.java` file:

```java
String string1 = "Hi";
String string2 = "Hello";
String string3 = "Hello";

System.out.println(string1.equals(string2));
System.out.println(string1.equals(string3));
System.out.println(string2.equals(string3));
```

This produces the following output:

```
false
false
true
```

These three print statements checked if `1` and `2`, `1` and `3`, or `2` and `3` were equal, which we can tell just from looking at the `String` objects that only `2` and `3` were, and so only the last print statement was `true` and the others were `false`.

We rarely expect two `String` objects to be identical, and so often we will compare them and want more information than just "not equal", which is where the `compareTo` method comes in. The `compareTo` method is called the same way as `equals`, but instead of returning a `boolean`, it returns an `int` where we can derive information. If the two `String` objects are equal, then this method will return `0`. If they are not equal, then it will return a different number:
- If the original `String` is longer than the comparison, the number will be positive.
- If the original `String` is shorter than the comparison, the number will be negative.
- If they are the same length, the number can be either positive or negative, and we only utilize the fact that it is not `0` to say they are not equal.

Here are a few examples from the `NotesCompareTo1.java` file:

```java
String string1 = "Hi";
String string2 = "Hello";
String string3 = "Hello";

System.out.println(string1.compareTo(string2));
System.out.println(string2.compareTo(string1));
System.out.println(string1.compareTo(string3));
System.out.println(string3.compareTo(string1));
System.out.println(string2.compareTo(string3));
System.out.println(string3.compareTo(string2));
```

This will produce the following output:

```
4
-4
4
-4
0
0
```

With the `compareTo`, we don't really care what the actualy value of the result is, just whether it was `0`, positive, or negative. It is important to note though, that because the `String` used with the dot operator comes first, the order matters as the result can be the opposite sign if they are flipped.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
