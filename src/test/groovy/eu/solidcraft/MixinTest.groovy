
package eu.solidcraft

import org.junit.Test

interface Animal {
    String getName()
}

@Category(Animal)
class CanWalk {
    void walk() { println getName() + " walking" }
}

@Category(Animal)
class CanFly {
    void fly() { println getName() + "talking" }
}

@Mixin(CanWalk)
class Dog implements Animal {
    String name = "Hans"
}

@Mixin([CanWalk, CanFly])
class Duck implements Animal {
    String name = "Donald"
}

class MixinTest {
    @Test
    void "should behave like animal"() {
        Dog dog = new Dog()
        dog.walk()

        Duck duck = new Duck()
        duck.walk()
        duck.fly()
    }
}
