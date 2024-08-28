const speech = new SpeechSynthesisUtterance();
let interval = []
document.querySelector("#me").addEventListener("click", () => {    
   temp = setInterval(() => {
        speak("Thank you")
    }, 1000)

    interval.push(temp)
})
document.querySelector("#me2").addEventListener("click", () => {
   interval.forEach(element => {
    clearInterval(element)
   });
})
  function speak(text) {
    const message = text;
    speechSynthesis.lang = "en";
    speech.text = message;
    window.speechSynthesis.speak(speech)
  }