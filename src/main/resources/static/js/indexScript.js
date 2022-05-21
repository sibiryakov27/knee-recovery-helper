let feedbackForm = document.querySelector(".feedback-form");
let topic = feedbackForm.querySelector("#topic");
let complaint = feedbackForm.querySelector("#complaint");

topic.addEventListener("change", function () {
  if (topic.value === "Жалоба на здоровье") {
    complaint.disabled = false;
  } else {
    complaint.disabled = true;
  }
});
