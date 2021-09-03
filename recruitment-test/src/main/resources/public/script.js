var devices = [];
const SWITCH_OFF = "switch-off.svg";
const SWITCH_ON = "switch-on.svg";
const DEVICES_ENDPOINT = "http://localhost:9000/devices/";

var onInitialLoad = function () {
  if (this.readyState == 4 && this.status == 200) {
    devices = JSON.parse(xhttp.responseText);
    renderTable(devices, mainTable);
  }
};

var renderTable = function (devices, table) {
  table.innerHTML = "";
  devices.forEach((device) => {
    var tr = document.createElement("tr");
    tr.dataset.location = device.location;
    tr.dataset.signal = device.signal;
    tr.dataset.connected = device.connected;
    tr.addEventListener("click", onRowClick);
    Object.keys(device).forEach((key) => {
      var td = document.createElement("td");
      td.innerHTML = device[key];
      tr.append(td);
    });
    table.append(tr);
  });
};

var onRowClick = function (e) {
  var relatedSection = document.getElementById("relatedSection");
  relatedTable.innerHTML = "";
  mainTable.innerHTML = e.currentTarget.innerHTML;
  relatedSection.style.display = "block";
  details.style.display = "flex";
  var location = e.currentTarget.dataset.location;
  var signal = e.currentTarget.dataset.signal;
  var connected = e.currentTarget.dataset.connected;
  const relatedDevices = devices.filter(
      (device) => device.location.toString() === location.toString()
  );
  renderTable(relatedDevices, relatedTable);
  renderKnob(signal);
  renderSwitch(connected);
};

var renderKnob = function (signal) {
  var knobContainer = document.getElementById("knob");
  knobContainer.innerHTML = "";
  var knob = pureknob.createKnob(300, 300);
  knob.setProperty("label", "Signal");
  knob.setProperty("valMin", -100);
  knob.setProperty("valMax", 1);
  knob.setValue(signal);
  var node = knob.node();
  knobContainer.appendChild(node);
};

var renderSwitch = function (connected) {
  var switchImg = document.getElementById("switch");
  switchImg.style.display = "block";
  const imgSrc = connected === "true" ? SWITCH_ON : SWITCH_OFF;
  switchImg.src = imgSrc;
};

var onFilterPressed = function () {
  relatedSection.style.display = "none";
  relatedTable.innerHTML = "";
  details.style.display = "none";
  const location = document.getElementById("location").value;
  const parentLocation = document.getElementById("parentLocation").value;
  const connected = document.getElementById("connected").checked;
  console.log(connected);
  const filteredDevices = filter(location, parentLocation, connected);
  renderTable(filteredDevices, mainTable);
};

const filter = function (location, parentLocation, connected) {
  return devices.filter((device) => {
    const locationMatches =
        location.toString() !== ""
            ? device["location"].toString() === location.toString()
            : true;
    const parentLocationMatches =
        parentLocation.toString() !== ""
            ? device["parentLocation"].toString() === parentLocation.toString()
            : true;
    const connectedMatches =
        connected.toString() !== ""
            ? device["connected"].toString() === connected.toString()
            : true;
    return locationMatches && parentLocationMatches && connectedMatches;
  });
};

const xhttp = new XMLHttpRequest();

document.addEventListener("DOMContentLoaded", () => {
  var button = document.getElementById("filter");
  const mainTable = document.getElementById("mainTable");
  const relatedTable = document.getElementById("relatedTable");
  const homeNav = document.getElementById("home");
  const details = document.getElementById("details");
  var relatedSection = document.getElementById("relatedSection");
  homeNav.addEventListener("click", () => {
    details.style.display = "none";
    relatedSection.style.display = "none";
    renderTable(devices, mainTable);
  });
  button.addEventListener("click", onFilterPressed);
  xhttp.onreadystatechange = onInitialLoad;
  xhttp.open("GET", DEVICES_ENDPOINT, true);
  xhttp.send();
});
