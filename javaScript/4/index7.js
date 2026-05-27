

//constructor=special method of defining the properties and methods of objects
function car(make, model, year, color){
    this.make=make,
    this.model=model,
    this.year=year,
    this.color=color;
    this.drive=function(){console.log(`you are driving ${this.make} ${this.model}`)}
}

const car1=new car("ford","mustang",2024,"black");
console.log(car1.make);
console.log(car1.model);
console.log(car1.year);
console.log(car1.color);
const car2=new car("porsche","911",2026,"black");
console.log(car2.make);
console.log(car2.model);
console.log(car2.year);
console.log(car2.color);
car1.drive();
car2.drive();