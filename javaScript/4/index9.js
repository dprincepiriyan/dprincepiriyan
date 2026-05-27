//inheritance

class Animal{
    alive=true;
    eat(){
        console.log(`this ${this.name} is eating`);
    }
    sleep(){
        console.log(`this ${this.name} is sleeping`);
    }
}
class Rabbit extends Animal{
    name="rabbit";
    run(){
        console.log(`This ${this.name} is running`);
    }
}
class Fish extends Animal{
    name="fish";
    swim(){
        console.log(`This ${this.name} is swimming`);
    }
}
class Hawk extends Animal{
    name="hawk";
    fly(){
        console.log(`This ${this.name} is flying`);
    }
}

const rabbit=new Rabbit();
const fish=new Fish();
const hawk=new Hawk();

console.log(rabbit.alive);
rabbit.eat();
rabbit.sleep();
rabbit.run();
hawk.fly();
fish.swim();

//super = Keyword is used in classes to call the constructor or access the properties and methods of a parent(superClass).
//this=this object
//super=the parent

class Animal2{
    constructor(name,age){
        this.name=name;
        this.age=age;
    }
}
class Rabbit2 extends Animal2{
    constructor(name, age, runSpeed){
        super(name,age);
        this.runSpeed=runSpeed;
    }
}
class Fish2 extends Animal2{
    constructor(name, age, SwimSpeed){
        super(name,age);
        this.SwimSpeed=SwimSpeed;
    }
}
class Hawk2 extends Animal2{
    constructor(name, age, flySpeed){
        super(name,age);
        this.flySpeed=flySpeed;
    }
}
const rabbit2=new Rabbit2("rabbit",1,25);
const fish2=new Fish2("fish",2,12);
const hawk2=new Hawk2("hawk",3,50);