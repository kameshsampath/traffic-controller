//Default state is stop all traffic
stopAllTraffic();
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
    await sleep(Math.max(n,s));
    await openEastAndWest(e, w);
  } else {
    console.log("Traffic flow E <-> W");
    await openEastAndWest(e, w);
    await sleep(Math.max(e,w));
    await openNorthAndSouth(n, s);
  }
};
