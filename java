/*
==========================================
ZaP Electronicz
Retro Website Script
Created for GitHub Pages
==========================================
*/

document.addEventListener("DOMContentLoaded", () => {

    /* ===========================
       Smooth Scrolling
    =========================== */

    document.querySelectorAll('a[href^="#"]').forEach(anchor => {

        anchor.addEventListener("click", function(e) {

            e.preventDefault();

            const target = document.querySelector(this.getAttribute("href"));

            if(target){

                target.scrollIntoView({

                    behavior: "smooth"

                });

            }

        });

    });



    /* ===========================
       Reveal Sections on Scroll
    =========================== */

    const observer = new IntersectionObserver((entries)=>{

        entries.forEach(entry=>{

            if(entry.isIntersecting){

                entry.target.classList.add("show");

            }

        });

    },{

        threshold:0.15

    });

    document.querySelectorAll(".section").forEach(section=>{

        section.classList.add("hidden");

        observer.observe(section);

    });



    /* ===========================
       Floating Particles
    =========================== */

    const particleContainer = document.createElement("div");

    particleContainer.className = "particles";

    document.body.appendChild(particleContainer);

    function createParticle(){

        const particle = document.createElement("span");

        particle.className = "particle";

        particle.style.left = Math.random()*100+"vw";

        particle.style.animationDuration =

            5 + Math.random()*8 + "s";

        particle.style.opacity =

            0.2 + Math.random()*0.8;

        particle.style.transform =

            `scale(${Math.random()*1.5})`;

        particleContainer.appendChild(particle);

        setTimeout(()=>{

            particle.remove();

        },13000);

    }

    setInterval(createParticle,250);



    /* ===========================
       Typewriter Effect
    =========================== */

    const title = document.querySelector(".hero h2");

    if(title){

        const text = title.textContent;

        title.textContent="";

        let i=0;

        function type(){

            if(i<text.length){

                title.textContent+=text.charAt(i);

                i++;

                setTimeout(type,40);

            }

        }

        type();

    }



    /* ===========================
       Random Lightning Flicker
    =========================== */

    function flicker(){

        document.body.classList.add("flash");

        setTimeout(()=>{

            document.body.classList.remove("flash");

        },120);

    }

    setInterval(()=>{

        if(Math.random()>.7){

            flicker();

        }

    },5000);



    /* ===========================
       Card Hover Glow
    =========================== */

    document.querySelectorAll(".card").forEach(card=>{

        card.addEventListener("mousemove",(e)=>{

            const rect=card.getBoundingClientRect();

            const x=e.clientX-rect.left;

            const y=e.clientY-rect.top;

            card.style.setProperty("--x",x+"px");

            card.style.setProperty("--y",y+"px");

        });

    });



    /* ===========================
       Gallery Hover Scale
    =========================== */

    document.querySelectorAll(".gallery-grid div").forEach(item=>{

        item.addEventListener("mouseenter",()=>{

            item.style.transform="scale(1.05)";

        });

        item.addEventListener("mouseleave",()=>{

            item.style.transform="scale(1)";

        });

    });



    /* ===========================
       Contact Form
    =========================== */

    const form=document.querySelector(".contact-form");

    if(form){

        form.addEventListener("submit",(e)=>{

            e.preventDefault();

            alert(
                "⚡ Thanks for contacting ZaP Electronicz!\n\nWe received your request.\n\nWe'll get back to you as soon as possible."
            );

            form.reset();

        });

    }



    /* ===========================
       Random Neon Pulse
    =========================== */

    const buttons=document.querySelectorAll(".btn,.quote-btn");

    setInterval(()=>{

        buttons.forEach(btn=>{

            btn.classList.toggle("pulse");

        });

    },2000);



    /* ===========================
       Mouse Glow
    =========================== */

    const glow=document.createElement("div");

    glow.className="cursor-glow";

    document.body.appendChild(glow);

    document.addEventListener("mousemove",(e)=>{

        glow.style.left=e.clientX+"px";

        glow.style.top=e.clientY+"px";

    });



    /* ===========================
       Konami Code Easter Egg
    =========================== */

    const konami=[

        "ArrowUp",

        "ArrowUp",

        "ArrowDown",

        "ArrowDown",

        "ArrowLeft",

        "ArrowRight",

        "ArrowLeft",

        "ArrowRight",

        "b",

        "a"

    ];

    let input=[];

    window.addEventListener("keydown",(e)=>{

        input.push(e.key);

        input=input.slice(-konami.length);

        if(JSON.stringify(input)==JSON.stringify(konami)){

            document.body.classList.toggle("konami");

            alert("🎮 KONAMI CODE ACTIVATED ⚡");

        }

    });



    /* ===========================
       Loading Screen
    =========================== */

    const loader=document.createElement("div");

    loader.className="loader";

    loader.innerHTML=`

        <div class="loader-box">

            <h1>ZaP Electronicz</h1>

            <p>Loading Retro Systems...</p>

        </div>

    `;

    document.body.appendChild(loader);

    window.addEventListener("load",()=>{

        setTimeout(()=>{

            loader.classList.add("hide");

            setTimeout(()=>{

                loader.remove();

            },1000);

        },1800);

    });



    /* ===========================
       Footer Year
    =========================== */

    const year=document.querySelector(".copyright");

    if(year){

        year.innerHTML=

        `© ${new Date().getFullYear()} ZaP Electronicz • Zyra + Pearse • Built with Retro Electricity ⚡`;

    }

});
