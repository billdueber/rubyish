package billdueber


import io.kotlintest.specs.DescribeSpec

import org.assertj.core.api.Assertions.*


class HelloWorldSpec: DescribeSpec({
    describe("Hello World") {
        it("Works") {
            assertThat(HelloWorld().excited_greeting())
                .isEqualTo("Hello World!!!")
        }

        it("Allows setting the property") {
            val hw = HelloWorld()
            hw.greeting = "Hi Bill"
            assertThat(hw.excited_greeting())
                .startsWith("Hi Bill")
            assertThat(hw.excited_greeting())
                .startsWith("Hi")
                .endsWith("!")
        }

    }
})