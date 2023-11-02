// Park data example
const parks = [
    { name: "Park1", image: "park1.jpg", type: "type1" },
    { name: "Park2", image: "park2.jpg", type: "type2" },
    // more park data
];

// showSlides
let slideIndex = 0;
showSlides();

function showSlides() {
    let i;
    const slides = document.getElementsByClassName("slide");

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1;
    }

    slides[slideIndex - 1].style.display = "block";

    setTimeout(showSlides, 2000); // Switchover interval, expressed in milliseconds
}


// initial park list
// function displayparks() {
//     const parkList = document.getElementById("parkList");
//     // parkList.innerHTML = "";
//     for (const park of parks) {
//         const card = document.createElement("div");
//         card.classList.add("park-card");
//         card.innerHTML = `
//             <img src="/images/${park.image}" alt="/images/${park.name}">
//             <h3>${park.name}</h3>
//             <p>${park.type}</p>
//         `;
//         parkList.appendChild(card);
//     }
// }
//
// displayparks();
let slideAdIndex = 0;
showAdSlides();

function showAdSlides() {
    let i;
    const slidesLeft = document.getElementsByClassName("ad-slide left");
    const slidesRight = document.getElementsByClassName("ad-slide right");

    for (i = 0; i < slidesLeft.length; i++) {
        slidesLeft[i].style.display = "none";
        slidesRight[i].style.display = "none";
    }

    slideAdIndex++;
    if (slideAdIndex > slidesLeft.length) {
        slideAdIndex = 1;
    }

    slidesLeft[slideAdIndex - 1].style.display = "block";
    slidesRight[slideAdIndex - 1].style.display = "block";

    setTimeout(showAdSlides, 2000); // Switchover interval, expressed in milliseconds
}

// park search
function searchparks() {
    const parkSearch = document.getElementById("parkSearch");
    const searchText = parkSearch.value.toLowerCase();
    const filteredparks = parks.filter((park) =>
        park.name.toLowerCase().includes(searchText)
    );
    displayparks(filteredparks);
}

function showImage(imageElement) {
    const imageUrl = imageElement.getAttribute('data-image-url');
    const overlay = document.querySelector('.overlay');
    const largeImage = document.querySelector('.large-image');

    overlay.style.display = 'block';
    largeImage.src = `/images/${imageUrl}`;
    largeImage.style.display = 'block';
}

function closeImage() {
    const overlay = document.querySelector('.overlay');
    const largeImage = document.querySelector('.large-image');

    overlay.style.display = 'none';
    largeImage.style.display = 'none';
}

document.querySelector('.overlay').addEventListener('click', closeImage);
