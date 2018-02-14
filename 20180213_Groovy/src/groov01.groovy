def printTheLine={
    println "it is $it and is of class ${it.class}"
}
def power = {a, b-> return a**b}


def x = 9
println "x is $x and is of class ${x.class}"
x = 99.99
printTheLine(x)
x = "Hello"
println "x is $x and is of class ${x.class}"
println x[1..4]
printTheLine(x)
println power(2,5)

def list = [9.3, 2.4, 8.6, new Date()]
printTheLine(list)
list.add("fish")
list[2] = "dog"

printTheLine(list)


