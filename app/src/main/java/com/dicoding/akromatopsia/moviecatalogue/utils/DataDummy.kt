package com.dicoding.akromatopsia.moviecatalogue.utils

import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            "m01",
            "A Star Is Born",
            "2018",
            "10/05/2018",
            "Drama, Romance, Music",
            "2h 16m",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "R.drawable.poster_a_star_is_born")
        )


        movies.add(
            MovieEntity(
            "m02",
            "Alita: Battle Angel",
            "2019",
            "02/14/2019",
            "Action, Science Fiction, Adventure",
            "2h 2m",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "R.drawable.poster_alita")
        )

        movies.add(
            MovieEntity(
            "m03",
            "Aquaman",
            "2018",
            "12/21/2018",
            "Action, Adventure, Fantasy",
            "2h 23m",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "R.drawable.poster_aquaman")
        )

        movies.add(
            MovieEntity(
            "m04",
            "Bohemian Rhapsody",
            "2018",
            "11/02/2018",
            "Music, Drama, History",
            "2h 15m",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "R.drawable.poster_bohemian")
        )

        movies.add(
            MovieEntity(
            "m05",
            "Avengers: Infinity War",
            "2018",
            "04/27/2018",
            "Adventure, Action, Science Fiction",
            "2h 29m",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "R.drawable.poster_infinity_war")
        )

        movies.add(
            MovieEntity(
            "m06",
            "Mary Queen of Scots",
            "2018",
            "12/21/2018",
            "Drama, History",
            "2h 4m",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "R.drawable.poster_marry_queen")
        )

        movies.add(
            MovieEntity(
            "m07",
            "Master Z: Ip Man Legacy",
            "2018",
            "12/26/2018",
            "Action",
            "1h 47m",
            "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "R.drawable.poster_master_z")
        )

        movies.add(
            MovieEntity(
            "m08",
            "Overlord",
            "2018",
            "11/09/2018",
            "Horror, War, Science Fiction",
            "1h 50m",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "R.drawable.poster_overlord")
        )

        movies.add(
            MovieEntity(
            "m09",
            "Serenity",
            "2019",
            "01/25/2019",
            "Thriller, Mystery, Drama",
            "1h 42m",
            "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "R.drawable.poster_serenity")
        )

        movies.add(
            MovieEntity(
            "m10",
            "Spider-Man: Into the Spider-Verse",
            "2018",
            "12/14/2018",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "1h 57m",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "R.drawable.poster_spiderman")
        )

        return movies
    }

    fun generateDummyTvshow(): List<TvshowEntity> {

        val tvshows = ArrayList<TvshowEntity>()

        tvshows.add(
            TvshowEntity(
            "t01",
            "Doom Patrol",
            "2019",
            "Sci-Fi & Fantasy, Action & Adventure, Comedy",
            "49m",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "R.drawable.poster_doom_patrol")
        )

        tvshows.add(
            TvshowEntity(
            "t02",
            "Dragon Ball",
            "1986",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
            "25m",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "R.drawable.poster_dragon_ball")
        )

        tvshows.add(
            TvshowEntity(
            "t03",
            "Game of Thrones",
            "2011",
            "Sci-Fi & Fantasy, Drama, Action & Adventure",
            "1h",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "R.drawable.poster_got")
        )

        tvshows.add(
            TvshowEntity(
            "t04",
            "Gotham",
            "2014",
            "Drama, Crime, Sci-Fi & Fantasy",
            "43m",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "R.drawable.poster_gotham")
        )

        tvshows.add(
            TvshowEntity(
            "t05",
            "Marvel's Iron Fist",
            "2017",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "55m",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "R.drawable.poster_iron_fist")
        )

        tvshows.add(
            TvshowEntity(
            "t06",
            "Naruto Shippuden",
            "2007",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "25m",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "R.drawable.poster_naruto_shipudden")
        )

        tvshows.add(
            TvshowEntity(
            "t07",
            "NCIS",
            "2003",
            "Crime, Action & Adventure, Drama",
            "45m",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "R.drawable.poster_ncis")
        )

        tvshows.add(
            TvshowEntity(
            "t08",
            "Supergirl",
            "2015",
            "Drama, Sci-Fi & Fantasy, Action & Adventure",
            "42m",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "R.drawable.poster_supergirl")
        )

        tvshows.add(
            TvshowEntity(
            "t09",
            "The Simpsons",
            "1989",
            "Family, Animation, Comedy",
            "22m",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "R.drawable.poster_the_simpson")
        )

        tvshows.add(
            TvshowEntity(
            "t10",
            "The Walking Dead",
            "2010",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "42m",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "R.drawable.poster_the_walking_dead")
        )

        return tvshows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(
            "m01",
            "A Star Is Born",
            "2018",
            "10/05/2018",
            "Drama, Romance, Music",
            "2h 16m",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))


        movies.add(MovieResponse(
            "m02",
            "Alita: Battle Angel",
            "2019",
            "02/14/2019",
            "Action, Science Fiction, Adventure",
            "2h 2m",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"))

        movies.add(MovieResponse(
            "m03",
            "Aquaman",
            "2018",
            "12/21/2018",
            "Action, Adventure, Fantasy",
            "2h 23m",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sP3t7rlg3UGlXqJvp3VA8liqGJL.jpg"))

        movies.add(MovieResponse(
            "m04",
            "Bohemian Rhapsody",
            "2018",
            "11/02/2018",
            "Music, Drama, History",
            "2h 15m",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))

        movies.add(MovieResponse(
            "m05",
            "Avengers: Infinity War",
            "2018",
            "04/27/2018",
            "Adventure, Action, Science Fiction",
            "2h 29m",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))

        movies.add(MovieResponse(
            "m06",
            "Mary Queen of Scots",
            "2018",
            "12/21/2018",
            "Drama, History",
            "2h 4m",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg"))

        movies.add(MovieResponse(
            "m07",
            "Master Z: Ip Man Legacy",
            "2018",
            "12/26/2018",
            "Action",
            "1h 47m",
            "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg"))

        movies.add(MovieResponse(
            "m08",
            "Overlord",
            "2018",
            "11/09/2018",
            "Horror, War, Science Fiction",
            "1h 50m",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"))

        movies.add(MovieResponse(
            "m09",
            "Serenity",
            "2019",
            "01/25/2019",
            "Thriller, Mystery, Drama",
            "1h 42m",
            "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg"))

        movies.add(MovieResponse(
            "m10",
            "Spider-Man: Into the Spider-Verse",
            "2018",
            "12/14/2018",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "1h 57m",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3cZn1k8x0bikrDKEy9ZKJ6Vdj30.jpg"))

        return movies
    }

    fun generateRemoteDummyTvshow(): List<TvshowResponse> {

        val tvshows = ArrayList<TvshowResponse>()

        tvshows.add(TvshowResponse(
            "t01",
            "Doom Patrol",
            "2019",
            "Sci-Fi & Fantasy, Action & Adventure, Comedy",
            "49m",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jhcd6aeRRl50AyOHoIGxv0sU0sw.jpg"))

        tvshows.add(TvshowResponse(
            "t02",
            "Dragon Ball",
            "1986",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
            "25m",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))

        tvshows.add(TvshowResponse(
            "t03",
            "Game of Thrones",
            "2011",
            "Sci-Fi & Fantasy, Drama, Action & Adventure",
            "1h",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/44rw2cOQrgUthZMhp3eibpXVy9p.jpg"))

        tvshows.add(TvshowResponse(
            "t04",
            "Gotham",
            "2014",
            "Drama, Crime, Sci-Fi & Fantasy",
            "43m",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/h53ACyT9MgVEVRlEvVyVBAUkLmh.jpg"))

        tvshows.add(TvshowResponse(
            "t05",
            "Marvel's Iron Fist",
            "2017",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "55m",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg"))

        tvshows.add(TvshowResponse(
            "t06",
            "Naruto Shippuden",
            "2007",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "25m",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg"))

        tvshows.add(TvshowResponse(
            "t07",
            "NCIS",
            "2003",
            "Crime, Action & Adventure, Drama",
            "45m",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"))

        tvshows.add(TvshowResponse(
            "t08",
            "Supergirl",
            "2015",
            "Drama, Sci-Fi & Fantasy, Action & Adventure",
            "42m",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg"))

        tvshows.add(TvshowResponse(
            "t09",
            "The Simpsons",
            "1989",
            "Family, Animation, Comedy",
            "22m",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"))

        tvshows.add(TvshowResponse(
            "t10",
            "The Walking Dead",
            "2010",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "42m",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bjU4tLlyp8W4yTB0Hqn8J1IDUnD.jpg"))

        return tvshows
    }

}