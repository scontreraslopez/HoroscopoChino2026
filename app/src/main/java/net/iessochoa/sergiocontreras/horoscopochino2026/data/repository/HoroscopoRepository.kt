package net.iessochoa.sergiocontreras.horoscopochino2026.data.repository

import net.iessochoa.sergiocontreras.horoscopochino2026.data.model.SignoChino

object HoroscopoRepository {

    val signos: List<SignoChino> = listOf(
        SignoChino(
            id = "rata",
            nombre = "Rata",
            emoji = "🐀",
            aniosRepresentativos = listOf(1960, 1972, 1984, 1996, 2008, 2020),
            descripcion = "Inteligente, adaptable y carismática. La Rata sabe aprovechar las oportunidades y se rodea de aliados leales.",
            prediccion2026 = "El Año del Caballo trae a la Rata oportunidades inesperadas en el ámbito laboral. Mantén la mente abierta y no rechaces las propuestas sin analizarlas. En el amor, una conversación pendiente abrirá puertas que creías cerradas."
        ),
        SignoChino(
            id = "buey",
            nombre = "Buey",
            emoji = "🐂",
            aniosRepresentativos = listOf(1961, 1973, 1985, 1997, 2009, 2021),
            descripcion = "Paciente, trabajador y fiable. El Buey consigue sus metas a base de constancia y no se deja llevar por la impaciencia.",
            prediccion2026 = "La paciencia del Buey se verá recompensada en 2026. Los proyectos sembrados el año pasado comenzarán a dar frutos. Cuida tu salud física, pues el ritmo acelerado del Caballo puede agotar incluso a los más resistentes."
        ),
        SignoChino(
            id = "tigre",
            nombre = "Tigre",
            emoji = "🐅",
            aniosRepresentativos = listOf(1962, 1974, 1986, 1998, 2010, 2022),
            descripcion = "Valiente, apasionado y natural líder. El Tigre actúa con decisión y raramente duda cuando tiene claro su objetivo.",
            prediccion2026 = "El Tigre y el Caballo comparten energía yang, por lo que este año se siente como terreno propio. Brillarás en proyectos creativos y liderazgo. Evita el exceso de confianza en las finanzas: el Caballo galopa rápido, pero también tropieza."
        ),
        SignoChino(
            id = "conejo",
            nombre = "Conejo",
            emoji = "🐇",
            aniosRepresentativos = listOf(1963, 1975, 1987, 1999, 2011, 2023),
            descripcion = "Diplomático, intuitivo y refinado. El Conejo prefiere la armonía y tiene un don especial para leer a las personas.",
            prediccion2026 = "Año de transformación para el Conejo. Aunque el Caballo le resulta algo impredecible, su intuición natural le ayudará a navegar los cambios con elegancia. Un viaje inesperado o un encuentro fortuito podría cambiar tu perspectiva para siempre."
        ),
        SignoChino(
            id = "dragon",
            nombre = "Dragón",
            emoji = "🐉",
            aniosRepresentativos = listOf(1964, 1976, 1988, 2000, 2012, 2024),
            descripcion = "Carismático, ambicioso y lleno de energía. El Dragón atrae la suerte de forma natural y no teme los grandes desafíos.",
            prediccion2026 = "Tras el poderoso año del Dragón, 2026 invita a consolidar los logros alcanzados. El Caballo impulsa la acción; aprovéchalo para completar lo que quedó pendiente. Relaciones nuevas y duraderas se forjan este año."
        ),
        SignoChino(
            id = "serpiente",
            nombre = "Serpiente",
            emoji = "🐍",
            aniosRepresentativos = listOf(1965, 1977, 1989, 2001, 2013, 2025),
            descripcion = "Sabia, misteriosa y reflexiva. La Serpiente observa antes de actuar y pocas veces comete el mismo error dos veces.",
            prediccion2026 = "La Serpiente cierra su ciclo personal con sabiduría. El Año del Caballo marca un nuevo comienzo: deja ir lo que no sirve y abraza la transformación. Tu capacidad de análisis será tu mayor arma en los cambios que se avecinan."
        ),
        SignoChino(
            id = "caballo",
            nombre = "Caballo",
            emoji = "🐎",
            aniosRepresentativos = listOf(1966, 1978, 1990, 2002, 2014, 2026),
            descripcion = "Libre, enérgico e independiente. El Caballo necesita espacio para correr y se apaga cuando lo encadenan a la rutina.",
            prediccion2026 = "¡Es tu año! El Caballo galopa con fuerza renovada hacia sus sueños. Todo lo que desees construir tiene el viento a favor. Energía desbordante, éxito en lo profesional y chispa en el amor: 2026 es completamente tuyo."
        ),
        SignoChino(
            id = "cabra",
            nombre = "Cabra",
            emoji = "🐐",
            aniosRepresentativos = listOf(1967, 1979, 1991, 2003, 2015, 2027),
            descripcion = "Creativa, empática y sensible. La Cabra florece en entornos de calma y tiene un talento innato para las artes.",
            prediccion2026 = "La Cabra encuentra en el Caballo un aliado dinámico. Este año favorece las artes, la creatividad y los lazos familiares. Acepta los cambios de plan con flexibilidad y descubrirás oportunidades ocultas donde menos lo esperes."
        ),
        SignoChino(
            id = "mono",
            nombre = "Mono",
            emoji = "🐒",
            aniosRepresentativos = listOf(1968, 1980, 1992, 2004, 2016, 2028),
            descripcion = "Ingenioso, curioso y versátil. El Mono aprende rápido, se adapta a cualquier situación y siempre encuentra una solución original.",
            prediccion2026 = "El ingenio del Mono brilla en el caótico galope del Caballo. Aprovecha tu adaptabilidad para destacar en entornos cambiantes. Ojo con dispersarte: elige bien tus batallas y ganarás las que de verdad importan."
        ),
        SignoChino(
            id = "gallo",
            nombre = "Gallo",
            emoji = "🐓",
            aniosRepresentativos = listOf(1969, 1981, 1993, 2005, 2017, 2029),
            descripcion = "Perfeccionista, puntual y observador. El Gallo no descansa hasta que cada detalle está en su sitio y exige lo mismo a los demás.",
            prediccion2026 = "El Gallo detallista puede sentir el año algo frenético, pero su disciplina le dará ventaja cuando otros se pierdan. Excelente momento para proyectos a largo plazo. En el amor, la honestidad abre todas las puertas."
        ),
        SignoChino(
            id = "perro",
            nombre = "Perro",
            emoji = "🐕",
            aniosRepresentativos = listOf(1970, 1982, 1994, 2006, 2018, 2030),
            descripcion = "Leal, honesto y protector. El Perro pone a sus seres queridos por encima de todo y jamás traiciona una confianza.",
            prediccion2026 = "El leal Perro encuentra en 2026 un año de vínculos sólidos y reconocimiento merecido. Tu lealtad será valorada como nunca antes. Presta atención a tu bienestar emocional: no puedes cuidar de los demás si no te cuidas a ti mismo."
        ),
        SignoChino(
            id = "cerdo",
            nombre = "Cerdo",
            emoji = "🐖",
            aniosRepresentativos = listOf(1971, 1983, 1995, 2007, 2019, 2031),
            descripcion = "Generoso, optimista y sincero. El Cerdo disfruta de los placeres de la vida y comparte todo lo que tiene sin esperar nada a cambio.",
            prediccion2026 = "El generoso Cerdo se beneficia del optimismo del Año del Caballo. Las finanzas mejoran si mantienes el orden. Año especialmente favorable para el amor y la familia. Una sorpresa grata llegará cuando menos lo esperes."
        ),
    )

    fun getSignoPorId(id: String): SignoChino? = signos.firstOrNull { it.id == id }
}