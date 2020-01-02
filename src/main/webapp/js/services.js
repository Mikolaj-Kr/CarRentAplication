function singleService(car){
  location.replace("/service-view?id=" + car);
}
function carList(){
  location.replace("/services");
}
function addService(car) {
  location.replace("/service-add?id=" + car);
}