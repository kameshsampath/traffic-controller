//NORTH
stopNorth = t => {
  $("#sigNorth").removeClass("green amber");
  $("#sigNorth").addClass("red");
};

slowNorth = t => {
  $("#sigNorth").removeClass("green red");
  $("#sigNorth").addClass("amber");
};

goNorth = t => {
  $("#sigNorth").removeClass("red amber");
  $("#sigNorth").addClass("green");
};

//EAST
stopEast = t => {
  $("#sigEast").removeClass("green amber");
  $("#sigEast").addClass("red");
};

slowEast = t => {
  $("#sigEast").removeClass("green red");
  $("#sigEast").addClass("amber");
};

goEast = t => {
  $("#sigEast").removeClass("red amber");
  $("#sigEast").addClass("green");
};

//SOUTH
stopSouth = t => {
  $("#sigSouth").removeClass("green amber");
  $("#sigSouth").addClass("red");
};

slowSouth = t => {
  $("#sigSouth").removeClass("green red");
  $("#sigSouth").addClass("amber");
};

goSouth = t => {
  $("#sigSouth").removeClass("red amber");
  $("#sigSouth").addClass("green");
};

//WEST
stopWest = t => {
  $("#sigWest").removeClass("green amber");
  $("#sigWest").addClass("red");
};

slowWest = t => {
  $("#sigWest").removeClass("green red");
  $("#sigWest").addClass("amber");
};

goWest = t => {
  $("#sigWest").removeClass("red amber");
  $("#sigWest").addClass("green");
};

sleep = (s) => {
    return new Promise(r => setTimeout(r,s*1000));
}
  
slowAllTraffic = () => {
  slowNorth();
  slowEast();
  slowSouth();
  slowWest();
};

stopAllTraffic = () => {
  stopNorth();
  stopEast();
  stopSouth();
  stopWest();
};

slowAllAndStopTraffic = async () => {
    slowAllTraffic();
    await sleep(5);
    stopAllTraffic();
    await sleep(5);
}

openEastAndWest = async (e,w) => {
    await slowAllAndStopTraffic();
    goEast();
    goWest();
}

openNorthAndSouth = async (n,s) => {
    await slowAllAndStopTraffic();
    goNorth();
    goSouth();
}
