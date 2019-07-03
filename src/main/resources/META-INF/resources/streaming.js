var source = new EventSource("/traffic/flow");
source.onmessage = async(event) => {
  console.log("Signal Data:", event.data);
  await regulateTraffic(JSON.parse(event.data));
};

source.onerror = function(e) {
  console.error(e);
  source.close();
  return;
};

regulateTraffic = async sd => {
  var e = sd["east"];
  var w = sd["west"];
  var n = sd["north"];
  var s = sd["south"];

  if ((n + s) >= (e + w)) {
    console.log("Traffic flow N <-> S");
    await openNorthAndSouth(n, s);    
    await sleep(Math.ceil(n+s/2));
    await openEastAndWest(e, w);
  } else {
    console.log("Traffic flow E <-> W");
    await openEastAndWest(e, w);
    await sleep(Math.ceil(n+s/2));
    await openNorthAndSouth(n, s);
  }
};
