# ElementaryCraft

A Minecraft mod that introduces elementary particles to both educate and entertain.


Getting Started
===============
Download MCreator van https://mcreator.net/download (Gebruik versie 2020.4 of later voor ondersteuning van git!)

Onder de downloadknop kan je kiezen voor Linux, Mac of Windows.Onder de tab 'How to install on: Windows Mac Linux' zijn instructies voor download en installatie
Eens MCreator is opgestart, klik je op 'Clone Remote'Bij 'Remote Git repository HTTPS URL' geef je volgende link in:

https://github.com/ElementaryCraftMod/ElementaryCraft

Geef jouw gebruikersnaam en wachtwoordKlik op 'Setup remote repository''Workspace setup for selected generator' download de files automatisch.

Klaar!

In de tab 'Mod Elements' vind je enkele blokken en items die als voorbeeld zijn gemaakt.

In de tab 'Resources' vind je de textures en dergelijke die gebruikt zijn om de items te maken.


Branching
========
het principe
--------------
Tijdens het werken aan een project, kan telkens de momentele toestand van de code opgeslagen worden. Zo een opgeslagen toestand is een commit. Een reeks commits vormt een branch. De hoofdbranch is de master branch. Daar komt code op die is nagekeken en goedgekeurd.

Jouw toevoegingen en aanpassingen moet je maken op een aparte branch. Dat is een aftakking van de code op een andere branch (bv de masterbranch). De code van de andere branch wordt gedupliceerd naar jouw branch. Wanneer je de code op jouw branch aanpast en opslaat in een nieuwe commits, dan wordt enkel jouw branch aangepast.

Om de aanpassingen in de code in jouw branch toe te passen op de andere branch, moet je een pull request openen. Dan wordt er automatisch gecontroleerd of de aanpassingen op jouw branch niet in conflict zijn met de aanpassingen die ondertussen eventueel gebeurd zijn op de andere branch. Bovendien kunnen anderen jouw code bekijken voor goedkeuring. Eens iedereen heeft ingestemd wordt jouw branch gemerged in de andere branch. 


In de praktijk
---------------
om in MCreator een nieuwe branch te maken, klik je linksonder op wat eruitizet als pijpleidingen en kies 'new branch from current'. Geen een zinvolle naam in en je bent klaar.

Voer nu aanpassingen uit in het project (zoals het toevoegen van blocks en items). Wanneer je een stukje werk hebt gedaan (of voor de veiligheid telkens wanneer je stopt met werken), klik je rechtsboven op de groene pijl 'Sync local changes with remote workspace' [dus niet de play-knop maar echt de pijl]. Er wordt gevraagd om een commit message in te geven (i.e. een zinvolle uitleg over wat er is aangepast, bijvoorbeeld 'texture neutrino verbeterd'). That's it.

Telkens wanneer je begint met werken, kan je best rechtsboven klikken op de blauwe pijl 'pull change from remote workspace'. Indien iemand aanpassingen heeft 'gecommit', dan trek je die zo binnen op jouw lokale computer.

Wanneer je linksonder op het branching-icoontje klikt, kan je ook veranderen naar een andere branch (die nog open is). Je kan bijvoorbeeld de branch bekijken die ik heb gemaakt 'neutrino'. Let wel op, wanneer je naar een andere branch gaat, dan zullen de aanpassingen die je op de huidige branch hebt gemaakt verloren gaan. Om dit te voorkomen moet je eerst jouw aanpassingen comitten (groene pijl rechtsboven)


Message #gettingstarted
Return to sendShift + Return to add a new line
