package com.techland.iris.helpers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomServerNameGenerator {
    private static final String[] SERVER_NAMES = new String[300];

    static {
        // Initialize the static array with 300 realistic server names
        String[] predefinedNames = {
                "Apollo", "Zeus", "Hera", "Athena", "Poseidon", "Hades", "Hermes", "Artemis", "Ares", "Hephaestus",
                "Demeter", "Dionysus", "Persephone", "Eos", "Helios", "Selene", "Nyx", "Gaia", "Chronos", "Oceanus",
                "Hyperion", "Themis", "Iapetus", "Coeus", "Crius", "Phoebe", "Rhea", "Tethys", "Mnemosyne", "Metis",
                "Prometheus", "Epimetheus", "Atlas", "Orion", "Sirius", "Lyra", "Vega", "Cygnus", "Andromeda", "Cassiopeia",
                "Draco", "Pegasus", "Phoenix", "Ursa", "Capella", "Arcturus", "Altair", "Polaris", "Rigel", "Betelgeuse",
                "Canopus", "Procyon", "Antares", "Spica", "Aquila", "Carina", "Centaurus", "Libra", "Scorpius", "Taurus",
                "Virgo", "Sagittarius", "Orpheus", "Achilles", "Odysseus", "Heracles", "Jason", "Theseus", "Medea", "Castor",
                "Pollux", "Chiron", "Pegasus", "Bellerophon", "Andromeda", "Perseus", "Cepheus", "Thalassa", "Eurydice",
                "Calypso", "Cerberus", "Echidna", "Hydra", "Sphinx", "Chimera", "Gorgons", "Medusa", "Pegasus", "Sirens",
                "Scylla", "Charybdis", "Minotaur", "Labyrinth", "Icarus", "Daedalus", "Oedipus", "Antigone", "Ismene",
                "Electra", "Clytemnestra", "Agamemnon", "Menelaus", "Helen", "Paris", "Priam", "Hecuba", "Cassandra",
                "Polyxena", "Laocoon", "Aeneas", "Dido", "Turnus", "Numitor", "Romulus", "Remus", "Caesar", "Augustus",
                "Nero", "Caligula", "Tiberius", "Claudius", "Trajan", "Hadrian", "Marcus", "Commodus", "Septimius",
                "Diocletian", "Constantine", "Justinian", "Theodora", "Belisarius", "Charlemagne", "Pepin", "Roland",
                "Lancelot", "Arthur", "Guinevere", "Merlin", "Morgana", "Gawain", "Percival", "Galahad", "Tristan",
                "Isolde", "Robin", "Marian", "Sherwood", "Friar", "Tuck", "Little", "John", "Sheriff", "Nottingham",
                "Ivanhoe", "Richard", "Lionheart", "Joan", "Arc", "Henry", "Elizabeth", "Victoria", "Albert", "Edward",
                "George", "Winston", "Churchill", "Napoleon", "Josephine", "Marie", "Antoinette", "Louis", "Versailles",
                "Eiffel", "DaVinci", "Michelangelo", "Raphael", "Donatello", "Galileo", "Copernicus", "Kepler", "Newton",
                "Einstein", "Tesla", "Edison", "Curie", "Hawking", "Feynman", "Bohr", "Planck", "Heisenberg", "Schrodinger",
                "Darwin", "Mendel", "Pasteur", "Fleming", "Nightingale", "Lister", "Jenner", "Gutenberg", "Luther",
                "Bach", "Beethoven", "Mozart", "Haydn", "Chopin", "Liszt", "Schubert", "Schumann", "Mendelssohn",
                "Brahms", "Mahler", "Wagner", "Strauss", "Debussy", "Ravel", "Stravinsky", "Prokofiev", "Shostakovich",
                "Tchaikovsky", "Rachmaninoff", "Vivaldi", "Handel", "Purcell", "Monteverdi", "Gershwin", "Bernstein",
                "Copland", "Barber", "Glass", "Reich", "Adams", "Harrison", "Cage", "Ives", "Britten", "Holst",
                "Elgar", "Sibelius", "Grieg", "Dvorak", "Janacek", "Smetana", "Bartok", "Kodaly", "Ligeti", "Stockhausen",
                "Boulez", "Messiaen", "Webern", "Berg", "Schoenberg", "Hindemith", "Nielsen", "Martinu", "Villa-Lobos",
                "Ginastera", "Piazzolla", "Pachelbel", "Albeniz", "Granados", "Falla", "Turina", "Rodrigo", "Lecuona"
        };

        System.arraycopy(predefinedNames, 0, SERVER_NAMES, 0, predefinedNames.length);
    }

    /**
     * Method to get a list of random server names.
     *
     * @param count The number of random server names to generate.
     * @return A list of random server names.
     * @throws IllegalArgumentException If count is less than 1 or greater than 300.
     */
    public List<String> getRandomServerNames(int count) {
        if (count < 1 || count > SERVER_NAMES.length) {
            throw new IllegalArgumentException("Count must be between 1 and 300.");
        }

        // Create a list from the static array
        List<String> serverNameList = new ArrayList<>();
        Collections.addAll(serverNameList, SERVER_NAMES);

        // Shuffle the list to randomize the order
        Collections.shuffle(serverNameList, new Random());

        // Return the first 'count' names from the shuffled list
        return serverNameList.subList(0, count);
    }
}

