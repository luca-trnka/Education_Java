Cíl:
Cílem tohoto úkolu je naučit se pracovat s Javou.

Funkce:
Vytvoření pole - náhodně i manuálně
Vytvoření pole - náhodně: Systém vytvoří náhodné pole s náhodnými čísly (kladnými i zápornými) náhodné délky. Vytvoř funkci, která toto pole vytvoří a vrátí ho.
Vytvoření pole - manuálně: Systém na základě vstupů uživatele vytvoří pole o uživatelem specifikované velikosti s prvky, které uživatel ručně vložil.
Vytištění pole: Systém projde pole a vytiskne na obrazovce všechny čísla v poli. Čísla jsou oddělena mezerou.
Přidání čísla do pole: Systém nad zadaným polem provede vložení nového prvku. Prvek je vložen na konec menu. Nové pole bude tedy mít velikost n+1, kde n je počet prvků v poli před provedením operace přidání. Systém toto pole vrátí. Vytvoř tedy funkci, která umí přidat do pole číslo a vrátí nové pole s tímto číslem.
Vyhledání největšího čísla: Systém nad zadaným polem najde největší číslo v poli a toto číslo vrátí. Vytvoř tedy funkci, která nad zadaným polem vrátí největší číslo.
Vyhledání nejmenšího čísla: Systém nad zadaným polem najde nejmenší číslo v poli a toto číslo vrátí. Vytvoř tedy funkci, která nad zadaným polem vrátí nejmenší číslo.
Odstranění čísla z pole: Systém umí ze zadaného pole odstranit zadané číslo popřípadě všechna tato čísla. Systém projde pole a pokud v něm najde číslo, které se má odstranit, tak ho odstraní. Pole tedy bude mít velikost n-1. Pokud je v poli více čísel k odstranění a uživatel si přeje odstranit všechny, pak systém vrátí pole, které má velikost n-m příčemž n je počet prvků původního pole a m je počet výskytů prvku, který se má odstranit. Vytvoř tedy funkci, která umí odstranit zadaná čísla ze zadaného pole a též umožňuje odstranit všechny výskyty daného čísla.
Smazání celého pole: Systém nad zadaným pole provede operaci smazání a to tak, že smaže celé pole. Vytvoř tedy funkci, která nad zadaným polem provede jeho smazání. Výstupem funkce je null.
Uvítací vstupní obrazovka:
Systém při zapnutí přivítá uživatele a nabídne mu dvě možnosti, jak vytvořit pole. Jedna je ruční (uživatel zadá čísla oddělená čárkou a zadávání ukončí enterem). Velikost pole je dynamická. Druhá možnost je nechat systém, ať sám vytvoří náhodně velké pole a naplní ho náhodnými čísly. Po vytvoření pole, ať již jedním či druhým způsobem nabídne uživateli následující možnosti:

Vytištění pole
Přidání čísla do pole
Vyhledání největšího čísla
Vyhledání nejmenšího čísla
Odstranění čísla z pole
Smazání celého pole
Ukončení programu
Pokud uživatel nevybere ukončení programu, tak s ním může stále pracovat, tzn je možné si nechat vytvořit pole, vytisknout ho, najít v něm největší číslo, přidat nové číslo, opět vytisknout a najít nejmenší číslo. Systém reaguje tak, jak mu určuje uživatel. V případě, že uživatel docílí stavu, že v poli není žádné číslo, nebo je smazané, tak mu systém opět nabídne generování nového pole.
