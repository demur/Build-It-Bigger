package com.udacity.demur.jokesjavalib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class JokesProvider {
    List<String> jokesList = asList(
            "Moses had the first tablet that could connect to the cloud.",
            "The first computer dates back to Adam and Eve. It was an Apple with limited memory, just one byte. And then everything crashed.",
            "Maybe if we start telling people the brain is an app they will start using it.",
            "Talking to a liberal is like trying to explain social media to a 70 years old.",
            "My mom said that if I don't get off my computer and do my homework she'll slam my head on the keyboard, but I think she's jokinfjreoiwjrtwe4to8rkljreun8f4ny84c8y4t58lym4wthylmhawt4mylt4amlathnatyn",
            "My email password has been hacked. That's the third time I've had to rename the cat.",
            "You must be an angel, because your texture mapping is so divine!",
            "They should build the wall with Hillary's emails because nobody can get over them.",
            "Entered what I ate today into my new fitness app and it just sent an ambulance to my house.",
            "We just got a fax. At work. We didn't know we had a fax machine. The entire department just stared at it. I poked it with a stick.",
            "Writing a horror screenplay. It starts off with a ringing phone. The person answers, and it's their mum saying \"I have a computer question.\"",
            "Is your name Wi-Fi? Because I'm feeling a connection.",
            "A computer once beat me at chess, but it was no match for me at kick boxing.",
            "So apparently RSVP'ing back to a wedding invite 'maybe next time' isn't the correct response.",
            "I think my neighbor is stalking me as she's been googling my name on her computer. I saw it through my telescope last night.",
            "I need more than 140 characters to tell you how beautiful you are.",
            "A clean house is the sign of a broken computer.",
            "I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect\".",
            "Doctor's office: All our records are electronic now just fill out these 12 forms.",
            "If I freeze, it's not a computer virus. I was just stunned by your beauty."
    );

    public String getJoke() {
        int randomInt = new Random().nextInt(jokesList.size());
        return jokesList.get(randomInt);
    }
}