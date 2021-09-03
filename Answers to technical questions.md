# Answers to technical questions

#### How long did you spend on the coding test? What would you add to your solution if you had more time? If you didn't spend much time on the coding test then use this as an opportunity to explain what you would add.

I spent around 6 hours developing the test. I would probably add integration tests for the Devices Controller and also improve the existing unit tests.

#### What was the most useful feature that was added to the latest version of your chosen language? Please include a snippet of code that shows how you've used it.

I haven't been able to work with Java 16 but i read that they are including sealed classes. I

```
public sealed interface ConstantDesc
    permits String, Integer, Float, Long, Double,
            ClassDesc, MethodTypeDesc, DynamicConstantDesc { ... }

// ClassDesc is designed for subclassing by JDK classes only
public sealed interface ClassDesc extends ConstantDesc
    permits PrimitiveClassDescImpl, ReferenceClassDescImpl { ... }
final class PrimitiveClassDescImpl implements ClassDesc { ... }
final class ReferenceClassDescImpl implements ClassDesc { ... }

// MethodTypeDesc is designed for subclassing by JDK classes only
public sealed interface MethodTypeDesc extends ConstantDesc
    permits MethodTypeDescImpl { ... }
final class MethodTypeDescImpl implements MethodTypeDesc { ... }

// DynamicConstantDesc is designed for subclassing by user code
public non-sealed abstract class DynamicConstantDesc implements ConstantDesc { ... }
```

My favorite feature of Java 11 that i've worked with is the new methods for the String and Files classes

This snippet lets you split a string by line breaks.

```
String linesString = "Hello world \n \n this is \n a test.";
List<String> lines = linesString.lines()
  .filter(line -> !line.isBlank())
  .map(String::strip)
  .collect(Collectors.toList());
```

#### How would you track down a performance issue in production? Have you ever had to do this?

Before a deployment if there was any change that we suspect can affect performance we would run load and performance tests using JMeter.
Normally during and after a deployment, i would check our APM services (Datadog and Elasticsearh) to see if there was a decrease in the performance of an specific endpoint.
If I the performance problem is hard to find i would use a profiler.

One time the JVM garbage collector wasn't disposing of instances of a String object when using the contains method inside a for loop. It looked something like this. I found this using our APM services and a profiler.

```
for(String test : tests){
    test.contains("hello");
}
```

#### How would you improve the APIs that you just created?

If the data came from a database i would probably implement an active cache using Guava since it comes from a JSON file i don't think it's neccesary.

### Please describe yourself using JSON.

Run the Spring boot project

```
{
  "name": "Jose",
  "lastname": "Hidalgo",
  "age": 27,
  "nationality": "Ecuadorian",
  "livesin": "Guayaquil",
  "passions": [
    "Programming",
    "Fitness",
    "Music"
  ],
  "interests": [
    "Technology",
    "Marketing"
  ],
  "dreams": [
    "To Travel around the World!"
  ]
}
```
