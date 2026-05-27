let minnum=1;
let maxnum=100;
let answer=Math.floor(Math.random()*(maxnum-minnum+1)+minnum);
let attempt=0;
let guess;
let running=true;
while(running){
    guess=window.prompt(`guess a number between ${minnum}-${maxnum}`);
    guess=Number(guess);
    if(isNaN(guess)){
        window.alert("please enter a valid number");
    }else if(guess<minnum||guess>maxnum){
        window.alert(`outside the boundary of the numbers ${minnum}-${maxnum}`);
    }else{
        attempt++;
        if(guess<answer){
            window.alert("too low vro");
        }else if(guess>answer){
            window.alert("too high vro");
        }else{
            window.alert(`congo u got the answer:- ${answer}. You took ${attempt} attempts to find the answer.`);
            running=false;
        }
    }
}