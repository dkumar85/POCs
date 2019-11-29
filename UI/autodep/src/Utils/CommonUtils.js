import axios from "axios";

const baseUrl = "http://localhost:9000/autodep/";

export function consumeGetUrl (endPoint) {
    const url = baseUrl+endPoint;
     return axios.get(url)
  .then(function (response) {
    // handle success
    //console.log(response);
    return response;       //without this return, return before axios will not work.
  })
  .catch(function (error) {
    // handle error
    //console.log(error);
    return error;
  })
  .finally(function () {
    // always executed
  });
}


 export function consumePostUrl(endPoint,body) {
    const url = baseUrl+endPoint;
    return axios.post(
    url,
    body
    )
    .then(function (response) {
      //console.log(response);
      return response;
    })
    .catch(function (error) {
      //console.log(error);
      return error;
    });
  
}