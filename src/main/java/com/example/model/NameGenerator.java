package com.example.model;

import org.apache.commons.lang.WordUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class NameGenerator {

    private static final List<String> firstMaleNames = Arrays.asList("JAMES", "JOHN", "ROBERT", "MICHAEL", "WILLIAM",
            "DAVID", "RICHARD", "CHARLES", "JOSEPH", "THOMAS", "CHRISTOPHER", "DANIEL", "PAUL", "MARK", "DONALD",
            "GEORGE", "KENNETH", "STEVEN", "EDWARD", "BRIAN", "RONALD", "ANTHONY", "KEVIN", "JASON", "MATTHEW",
            "GARY", "TIMOTHY", "JOSE", "LARRY", "JEFFREY", "FRANK", "SCOTT", "ERIC", "STEPHEN", "ANDREW", "RAYMOND",
            "GREGORY", "JOSHUA", "JERRY", "DENNIS", "WALTER", "PATRICK", "PETER", "HAROLD", "DOUGLAS", "HENRY", "CARL",
            "ARTHUR", "RYAN", "ROGER", "JOE", "JUAN", "JACK", "ALBERT", "JONATHAN", "JUSTIN", "TERRY", "GERALD",
            "KEITH", "SAMUEL", "WILLIE", "RALPH", "LAWRENCE", "NICHOLAS", "ROY", "BENJAMIN", "BRUCE", "BRANDON",
            "ADAM", "HARRY", "FRED", "WAYNE", "BILLY", "STEVE", "LOUIS", "JEREMY", "AARON", "RANDY", "HOWARD",
            "EUGENE", "CARLOS", "RUSSELL", "BOBBY", "VICTOR", "MARTIN", "ERNEST", "PHILLIP", "TODD", "JESSE", "CRAIG",
            "ALAN", "SHAWN", "CLARENCE", "SEAN", "PHILIP", "CHRIS", "JOHNNY", "EARL", "JIMMY", "ANTONIO", "DANNY",
            "BRYAN", "TONY", "LUIS", "MIKE", "STANLEY", "LEONARD", "NATHAN", "DALE", "MANUEL", "RODNEY", "CURTIS",
            "NORMAN", "ALLEN", "MARVIN", "VINCENT", "GLENN", "JEFFERY", "TRAVIS", "JEFF", "CHAD", "JACOB", "LEE",
            "MELVIN", "ALFRED", "KYLE", "FRANCIS", "BRADLEY", "JESUS", "HERBERT", "FREDERICK", "RAY", "JOEL", "EDWIN",
            "DON", "EDDIE", "RICKY", "TROY", "RANDALL", "BARRY", "ALEXANDER", "BERNARD", "MARIO", "LEROY", "FRANCISCO",
            "MARCUS", "MICHEAL", "THEODORE", "CLIFFORD", "MIGUEL", "OSCAR", "JAY", "JIM", "TOM", "CALVIN", "ALEX",
            "JON", "RONNIE", "BILL", "LLOYD", "TOMMY", "LEON", "DEREK", "WARREN", "DARRELL", "JEROME", "FLOYD",
            "LEO", "ALVIN", "TIM", "WESLEY", "GORDON", "DEAN", "GREG", "JORGE", "DUSTIN", "PEDRO", "DERRICK", "DAN",
            "LEWIS", "ZACHARY", "COREY", "HERMAN", "MAURICE", "VERNON", "ROBERTO", "CLYDE", "GLEN", "HECTOR", "SHANE",
            "RICARDO", "SAM", "RICK", "LESTER", "BRENT", "RAMON", "CHARLIE", "TYLER", "GILBERT", "GENE", "MARC",
            "REGINALD", "RUBEN", "BRETT", "ANGEL", "NATHANIEL", "RAFAEL", "LESLIE", "EDGAR", "MILTON", "RAUL",
            "BEN", "CHESTER", "CECIL", "DUANE", "FRANKLIN", "ANDRE", "ELMER", "BRAD", "GABRIEL", "RON", "MITCHELL",
            "ROLAND", "ARNOLD", "HARVEY", "JARED", "ADRIAN", "KARL", "CORY", "CLAUDE", "ERIK", "DARRYL", "JAMIE",
            "NEIL", "JESSIE", "CHRISTIAN", "JAVIER", "FERNANDO", "CLINTON", "TED", "MATHEW", "TYRONE", "DARREN",
            "LONNIE", "LANCE", "CODY", "JULIO", "KELLY", "KURT", "ALLAN", "NELSON", "GUY", "CLAYTON", "HUGH", "MAX",
            "DWAYNE", "DWIGHT", "ARMANDO", "FELIX", "JIMMIE", "EVERETT", "JORDAN", "IAN", "WALLACE", "KEN", "BOB",
            "JAIME", "CASEY", "ALFREDO", "ALBERTO", "DAVE", "IVAN", "JOHNNIE", "SIDNEY", "BYRON", "JULIAN", "ISAAC",
            "MORRIS", "CLIFTON", "WILLARD", "DARYL", "ROSS", "VIRGIL", "ANDY", "MARSHALL", "SALVADOR", "PERRY", "KIRK",
            "SERGIO", "MARION", "TRACY", "SETH", "KENT", "TERRANCE", "RENE", "EDUARDO", "TERRENCE", "ENRIQUE",
            "FREDDIE", "WADE");

    private static final List<String> firstFemaleNames = Arrays.asList("MARY", "PATRICIA", "LINDA", "BARBARA",
            "ELIZABETH", "JENNIFER", "MARIA", "SUSAN", "MARGARET", "DOROTHY", "LISA", "NANCY", "KAREN", "BETTY",
            "HELEN", "SANDRA", "DONNA", "CAROL", "RUTH", "SHARON", "MICHELLE", "LAURA", "SARAH", "KIMBERLY", "DEBORAH",
            "JESSICA", "SHIRLEY", "CYNTHIA", "ANGELA", "MELISSA", "BRENDA", "AMY", "ANNA", "REBECCA", "VIRGINIA",
            "KATHLEEN", "PAMELA", "MARTHA", "DEBRA", "AMANDA", "STEPHANIE", "CAROLYN", "CHRISTINE", "MARIE", "JANET",
            "CATHERINE", "FRANCES", "ANN", "JOYCE", "DIANE", "ALICE", "JULIE", "HEATHER", "TERESA", "DORIS", "GLORIA",
            "EVELYN", "JEAN", "CHERYL", "MILDRED", "KATHERINE", "JOAN", "ASHLEY", "JUDITH", "ROSE", "JANICE", "KELLY",
            "NICOLE", "JUDY", "CHRISTINA", "KATHY", "THERESA", "BEVERLY", "DENISE", "TAMMY", "IRENE", "JANE", "LORI",
            "RACHEL", "MARILYN", "ANDREA", "KATHRYN", "LOUISE", "SARA", "ANNE", "JACQUELINE", "WANDA", "BONNIE",
            "JULIA", "RUBY", "LOIS", "TINA", "PHYLLIS", "NORMA", "PAULA", "DIANA", "ANNIE", "LILLIAN", "EMILY",
            "ROBIN", "PEGGY", "CRYSTAL", "GLADYS", "RITA", "DAWN", "CONNIE", "FLORENCE", "TRACY", "EDNA", "TIFFANY",
            "CARMEN", "ROSA", "CINDY", "GRACE", "WENDY", "VICTORIA", "EDITH", "KIM", "SHERRY", "SYLVIA", "JOSEPHINE",
            "THELMA", "SHANNON", "SHEILA", "ETHEL", "ELLEN", "ELAINE", "MARJORIE", "CARRIE", "CHARLOTTE", "MONICA",
            "ESTHER", "PAULINE", "EMMA", "JUANITA", "ANITA", "RHONDA", "HAZEL", "AMBER", "EVA", "DEBBIE", "APRIL",
            "LESLIE", "CLARA", "LUCILLE", "JAMIE", "JOANNE", "ELEANOR", "VALERIE", "DANIELLE", "MEGAN", "ALICIA",
            "SUZANNE", "MICHELE", "GAIL", "BERTHA", "DARLENE", "VERONICA", "JILL", "ERIN", "GERALDINE", "LAUREN",
            "CATHY", "JOANN", "LORRAINE", "LYNN", "SALLY", "REGINA", "ERICA", "BEATRICE", "DOLORES", "BERNICE",
            "AUDREY", "YVONNE", "ANNETTE", "JUNE", "SAMANTHA", "MARION", "DANA", "STACY", "ANA", "RENEE", "IDA",
            "VIVIAN", "ROBERTA", "HOLLY", "BRITTANY", "MELANIE", "LORETTA", "YOLANDA", "JEANETTE", "LAURIE", "KATIE",
            "KRISTEN", "VANESSA", "ALMA", "SUE", "ELSIE", "BETH", "JEANNE", "VICKI", "CARLA", "TARA", "ROSEMARY",
            "EILEEN", "TERRI", "GERTRUDE", "LUCY", "TONYA", "ELLA", "STACEY", "WILMA", "GINA", "KRISTIN", "JESSIE",
            "NATALIE", "AGNES", "VERA", "WILLIE", "CHARLENE", "BESSIE", "DELORES", "MELINDA", "PEARL", "ARLENE",
            "MAUREEN", "COLLEEN", "ALLISON", "TAMARA", "JOY", "GEORGIA", "CONSTANCE", "LILLIE", "CLAUDIA", "JACKIE",
            "MARCIA", "TANYA", "NELLIE", "MINNIE", "MARLENE", "HEIDI", "GLENDA", "LYDIA", "VIOLA", "COURTNEY",
            "MARIAN", "STELLA", "CAROLINE", "DORA", "JO", "VICKIE", "MATTIE", "TERRY", "MAXINE", "IRMA", "MABEL",
            "MARSHA", "MYRTLE", "LENA", "CHRISTY", "DEANNA", "PATSY", "HILDA", "GWENDOLYN", "JENNIE", "NORA", "MARGIE",
            "NINA", "CASSANDRA", "LEAH", "PENNY", "KAY", "PRISCILLA", "NAOMI", "CAROLE", "BRANDY", "OLGA", "BILLIE",
            "DIANNE", "TRACEY", "LEONA", "JENNY", "FELICIA", "SONIA", "MIRIAM", "VELMA", "BECKY", "BOBBIE", "VIOLET",
            "KRISTINA", "TONI", "MISTY", "MAE", "SHELLY", "DAISY", "RAMONA", "SHERRI", "ERIKA", "KATRINA", "CLAIRE");

    private static final List<String> lastNames = Arrays.asList("SMITH", "JOHNSON", "WILLIAMS", "JONES", "BROWN",
            "DAVIS", "MILLER", "WILSON", "MOORE", "TAYLOR", "ANDERSON", "THOMAS", "JACKSON", "WHITE", "HARRIS",
            "MARTIN", "THOMPSON", "GARCIA", "MARTINEZ", "ROBINSON", "CLARK", "RODRIGUEZ", "LEWIS", "LEE", "WALKER",
            "HALL", "ALLEN", "YOUNG", "HERNANDEZ", "KING", "WRIGHT", "LOPEZ", "HILL", "SCOTT", "GREEN", "ADAMS",
            "BAKER", "GONZALEZ", "NELSON", "CARTER", "MITCHELL", "PEREZ", "ROBERTS", "TURNER", "PHILLIPS", "CAMPBELL",
            "PARKER", "EVANS", "EDWARDS", "COLLINS", "STEWART", "SANCHEZ", "MORRIS", "ROGERS", "REED", "COOK", "MORGAN",
            "BELL", "MURPHY", "BAILEY", "RIVERA", "COOPER", "RICHARDSON", "COX", "HOWARD", "WARD", "TORRES", "PETERSON",
            "GRAY", "RAMIREZ", "JAMES", "WATSON", "BROOKS", "KELLY", "SANDERS", "PRICE", "BENNETT", "WOOD", "BARNES",
            "ROSS", "HENDERSON", "COLEMAN", "JENKINS", "PERRY", "POWELL", "LONG", "PATTERSON", "HUGHES", "FLORES",
            "WASHINGTON", "BUTLER", "SIMMONS", "FOSTER", "GONZALES", "BRYANT", "ALEXANDER", "RUSSELL", "GRIFFIN",
            "DIAZ", "HAYES", "MYERS", "FORD", "HAMILTON", "GRAHAM", "SULLIVAN", "WALLACE", "WOODS", "COLE", "WEST",
            "JORDAN", "OWENS", "REYNOLDS", "FISHER", "ELLIS", "HARRISON", "GIBSON", "MCDONALD", "CRUZ", "MARSHALL",
            "ORTIZ", "GOMEZ", "MURRAY", "FREEMAN", "WELLS", "WEBB", "SIMPSON", "STEVENS", "TUCKER", "PORTER", "HUNTER",
            "HICKS", "CRAWFORD", "HENRY", "BOYD", "MASON", "MORALES", "KENNEDY", "WARREN", "DIXON", "RAMOS", "REYES",
            "BURNS", "GORDON", "SHAW", "HOLMES", "RICE", "ROBERTSON", "HUNT", "BLACK", "DANIELS", "PALMER", "MILLS",
            "NICHOLS", "GRANT", "KNIGHT", "FERGUSON", "ROSE", "STONE", "HAWKINS", "DUNN", "PERKINS", "HUDSON",
            "SPENCER", "GARDNER", "STEPHENS", "PAYNE", "PIERCE", "BERRY", "MATTHEWS", "ARNOLD", "WAGNER", "WILLIS",
            "RAY", "WATKINS", "OLSON", "CARROLL", "DUNCAN", "SNYDER", "HART", "CUNNINGHAM", "BRADLEY", "LANE",
            "ANDREWS", "RUIZ", "HARPER", "FOX", "RILEY", "ARMSTRONG", "CARPENTER", "WEAVER", "GREENE", "LAWRENCE",
            "ELLIOTT", "CHAVEZ", "SIMS", "AUSTIN", "PETERS", "KELLEY", "FRANKLIN", "LAWSON", "FIELDS", "GUTIERREZ",
            "RYAN", "SCHMIDT", "CARR", "VASQUEZ", "CASTILLO", "WHEELER", "CHAPMAN", "OLIVER", "MONTGOMERY", "RICHARDS",
            "WILLIAMSON", "JOHNSTON", "BANKS", "MEYER", "BISHOP", "MCCOY", "HOWELL", "ALVAREZ", "MORRISON", "HANSEN",
            "FERNANDEZ", "GARZA", "HARVEY", "LITTLE", "BURTON", "STANLEY", "NGUYEN", "GEORGE", "JACOBS", "REID", "KIM",
            "FULLER", "LYNCH", "DEAN", "GILBERT", "GARRETT", "ROMERO", "WELCH", "LARSON", "FRAZIER", "BURKE", "HANSON",
            "DAY", "MENDOZA", "MORENO", "BOWMAN", "MEDINA", "FOWLER", "BREWER", "HOFFMAN", "CARLSON", "SILVA",
            "PEARSON", "HOLLAND", "DOUGLAS", "FLEMING", "JENSEN", "VARGAS", "BYRD", "DAVIDSON", "HOPKINS", "MAY",
            "TERRY", "HERRERA", "WADE", "SOTO", "WALTERS", "CURTIS", "NEAL", "CALDWELL", "LOWE", "JENNINGS", "BARNETT",
            "GRAVES", "JIMENEZ", "HORTON", "SHELTON", "BARRETT", "OBRIEN", "CASTRO", "SUTTON", "GREGORY", "MCKINNEY",
            "LUCAS", "MILES", "CRAIG", "RODRIQUEZ", "CHAMBERS", "HOLT", "LAMBERT", "FLETCHER", "WATTS", "BATES", "HALE",
            "RHODES", "PENA", "BECK", "NEWMAN", "HAYNES", "MCDANIEL", "MENDEZ", "BUSH", "VAUGHN", "PARKS", "DAWSON",
            "SANTIAGO", "NORRIS", "HARDY", "LOVE", "STEELE", "CURRY", "POWERS", "SCHULTZ", "BARKER", "GUZMAN", "PAGE",
            "MUNOZ", "BALL", "KELLER", "CHANDLER", "WEBER", "LEONARD", "WALSH", "LYONS", "RAMSEY", "WOLFE", "SCHNEIDER",
            "MULLINS", "BENSON", "SHARP", "BOWEN", "DANIEL", "BARBER", "CUMMINGS", "HINES", "BALDWIN", "GRIFFITH",
            "VALDEZ", "HUBBARD", "SALAZAR", "REEVES", "WARNER", "STEVENSON", "BURGESS", "SANTOS", "TATE", "CROSS",
            "GARNER", "MANN", "MACK", "MOSS", "THORNTON", "DENNIS", "MCGEE", "FARMER", "DELGADO", "AGUILAR", "VEGA",
            "GLOVER", "MANNING", "COHEN", "HARMON", "RODGERS", "ROBBINS", "NEWTON", "TODD", "BLAIR", "HIGGINS",
            "INGRAM", "REESE", "CANNON", "STRICKLAND", "TOWNSEND", "POTTER", "GOODWIN", "WALTON", "ROWE", "HAMPTON",
            "ORTEGA", "PATTON", "SWANSON", "JOSEPH", "FRANCIS", "GOODMAN", "MALDONADO", "YATES", "BECKER", "ERICKSON",
            "HODGES", "RIOS", "CONNER", "ADKINS", "WEBSTER", "NORMAN", "MALONE", "HAMMOND", "FLOWERS", "COBB", "MOODY",
            "QUINN", "BLAKE", "MAXWELL", "POPE", "FLOYD", "OSBORNE", "PAUL", "MCCARTHY", "GUERRERO", "LINDSEY",
            "ESTRADA", "SANDOVAL", "GIBBS", "TYLER", "GROSS", "FITZGERALD", "STOKES", "DOYLE", "SHERMAN", "SAUNDERS",
            "WISE", "COLON", "GILL", "ALVARADO", "GREER", "PADILLA", "SIMON", "WATERS", "NUNEZ", "BALLARD", "SCHWARTZ",
            "MCBRIDE", "HOUSTON", "CHRISTENSEN", "KLEIN", "PRATT", "BRIGGS", "PARSONS", "MCLAUGHLIN", "ZIMMERMAN",
            "FRENCH", "BUCHANAN", "MORAN", "COPELAND", "ROY", "PITTMAN", "BRADY", "MCCORMICK", "HOLLOWAY", "BROCK",
            "POOLE", "FRANK", "LOGAN", "OWEN", "BASS", "MARSH", "DRAKE", "WONG", "JEFFERSON", "PARK", "MORTON",
            "ABBOTT", "SPARKS", "PATRICK", "NORTON", "HUFF", "CLAYTON", "MASSEY", "LLOYD", "FIGUEROA", "CARSON",
            "BOWERS", "ROBERSON", "BARTON", "TRAN", "LAMB", "HARRINGTON", "CASEY", "BOONE", "CORTEZ", "CLARKE",
            "MATHIS", "SINGLETON", "WILKINS", "CAIN", "BRYAN", "UNDERWOOD", "HOGAN", "MCKENZIE", "COLLIER", "LUNA",
            "PHELPS", "MCGUIRE", "ALLISON", "BRIDGES", "WILKERSON", "NASH", "SUMMERS", "ATKINS", "WILCOX", "PITTS",
            "CONLEY", "MARQUEZ", "BURNETT", "RICHARD", "COCHRAN", "CHASE", "DAVENPORT", "HOOD", "GATES", "CLAY",
            "AYALA", "SAWYER", "ROMAN", "VAZQUEZ", "DICKERSON", "HODGE", "ACOSTA", "FLYNN", "ESPINOZA", "NICHOLSON",
            "MONROE", "WOLF", "MORROW", "KIRK", "RANDALL", "ANTHONY", "WHITAKER", "OCONNOR", "SKINNER", "WARE",
            "MOLINA", "KIRBY", "HUFFMAN", "BRADFORD", "CHARLES", "GILMORE", "DOMINGUEZ", "ONEAL", "BRUCE", "LANG",
            "COMBS", "KRAMER", "HEATH", "HANCOCK", "GALLAGHER", "GAINES", "SHAFFER", "SHORT", "WIGGINS", "MATHEWS",
            "MCCLAIN", "FISCHER", "WALL", "SMALL", "MELTON", "HENSLEY", "BOND", "DYER", "CAMERON", "GRIMES",
            "CONTRERAS", "CHRISTIAN", "WYATT", "BAXTER", "SNOW", "MOSLEY", "SHEPHERD", "LARSEN", "HOOVER", "BEASLEY",
            "GLENN", "PETERSEN", "WHITEHEAD", "MEYERS", "KEITH", "GARRISON", "VINCENT", "SHIELDS", "HORN", "SAVAGE",
            "OLSEN", "SCHROEDER", "HARTMAN", "WOODARD", "MUELLER", "KEMP", "DELEON", "BOOTH", "PATEL", "CALHOUN",
            "WILEY", "EATON", "CLINE", "NAVARRO", "HARRELL", "LESTER", "HUMPHREY", "PARRISH", "DURAN", "HUTCHINSON",
            "HESS", "DORSEY", "BULLOCK", "ROBLES", "BEARD", "DALTON", "AVILA", "VANCE", "RICH", "BLACKWELL", "YORK",
            "JOHNS", "BLANKENSHIP", "TREVINO", "SALINAS", "CAMPOS", "PRUITT", "MOSES", "CALLAHAN", "GOLDEN", "MONTOYA",
            "HARDIN", "GUERRA", "MCDOWELL", "CAREY", "STAFFORD", "GALLEGOS", "HENSON", "WILKINSON", "BOOKER",
            "MERRITT", "MIRANDA", "ATKINSON", "ORR", "DECKER", "HOBBS", "PRESTON", "TANNER", "KNOX", "PACHECO",
            "STEPHENSON", "GLASS", "ROJAS", "SERRANO", "MARKS", "HICKMAN", "ENGLISH", "SWEENEY", "STRONG", "PRINCE",
            "MCCLURE", "CONWAY", "WALTER", "ROTH", "MAYNARD", "FARRELL", "LOWERY", "HURST", "NIXON", "WEISS",
            "TRUJILLO", "ELLISON", "SLOAN", "JUAREZ", "WINTERS", "MCLEAN", "RANDOLPH", "LEON", "BOYER", "VILLARREAL",
            "MCCALL", "GENTRY", "CARRILLO", "KENT", "AYERS", "LARA", "SHANNON", "SEXTON", "PACE", "HULL", "LEBLANC",
            "BROWNING", "VELASQUEZ", "LEACH", "CHANG", "HOUSE", "SELLERS", "HERRING", "NOBLE", "FOLEY", "BARTLETT",
            "MERCADO", "LANDRY", "DURHAM", "WALLS", "BARR", "MCKEE", "BAUER", "RIVERS", "EVERETT", "BRADSHAW", "PUGH",
            "VELEZ", "RUSH", "ESTES", "DODSON", "MORSE", "SHEPPARD", "WEEKS", "CAMACHO", "BEAN", "BARRON", "LIVINGSTON",
            "MIDDLETON", "SPEARS", "BRANCH", "BLEVINS", "CHEN", "KERR", "MCCONNELL", "HATFIELD", "HARDING", "ASHLEY",
            "SOLIS", "HERMAN", "FROST", "GILES", "BLACKBURN", "WILLIAM", "PENNINGTON", "WOODWARD", "FINLEY",
            "MCINTOSH", "KOCH", "BEST", "SOLOMON", "MCCULLOUGH", "DUDLEY", "NOLAN", "BLANCHARD", "RIVAS", "BRENNAN",
            "MEJIA", "KANE", "BENTON", "JOYCE", "BUCKLEY", "HALEY", "VALENTINE", "MADDOX", "RUSSO", "MCKNIGHT", "BUCK",
            "MOON", "MCMILLAN", "CROSBY", "BERG", "DOTSON", "MAYS", "ROACH", "CHURCH", "CHAN", "RICHMOND", "MEADOWS",
            "FAULKNER", "ONEILL", "KNAPP", "KLINE", "BARRY", "OCHOA", "JACOBSON", "GAY", "AVERY", "HENDRICKS", "HORNE",
            "SHEPARD", "HEBERT", "CHERRY", "CARDENAS", "MCINTYRE", "WHITNEY", "WALLER", "HOLMAN", "DONALDSON", "CANTU",
            "TERRELL", "MORIN", "GILLESPIE", "FUENTES", "TILLMAN", "SANFORD", "BENTLEY", "PECK", "KEY", "SALAS",
            "ROLLINS", "GAMBLE", "DICKSON", "BATTLE", "SANTANA", "CABRERA", "CERVANTES", "HOWE", "HINTON", "HURLEY",
            "SPENCE", "ZAMORA", "YANG", "MCNEIL", "SUAREZ", "CASE", "PETTY", "GOULD", "MCFARLAND", "SAMPSON", "CARVER",
            "BRAY", "ROSARIO", "MACDONALD", "STOUT", "HESTER", "MELENDEZ", "DILLON", "FARLEY", "HOPPER", "GALLOWAY",
            "POTTS", "BERNARD", "JOYNER", "STEIN", "AGUIRRE", "OSBORN", "MERCER", "BENDER", "FRANCO", "ROWLAND",
            "SYKES", "BENJAMIN", "TRAVIS", "PICKETT", "CRANE", "SEARS", "MAYO", "DUNLAP", "HAYDEN", "WILDER", "MCKAY",
            "COFFEY", "MCCARTY", "EWING", "COOLEY", "VAUGHAN", "BONNER", "COTTON", "HOLDER", "STARK", "FERRELL",
            "CANTRELL", "FULTON", "LYNN", "LOTT", "CALDERON", "ROSA", "POLLARD", "HOOPER", "BURCH", "MULLEN", "FRY",
            "RIDDLE", "LEVY", "DAVID", "DUKE", "ODONNELL", "GUY", "MICHAEL", "BRITT", "FREDERICK", "DAUGHERTY",
            "BERGER", "DILLARD", "ALSTON", "JARVIS", "FRYE", "RIGGS", "CHANEY", "ODOM", "DUFFY", "FITZPATRICK",
            "VALENZUELA", "MERRILL", "MAYER", "ALFORD", "MCPHERSON", "ACEVEDO", "DONOVAN", "BARRERA", "ALBERT",
            "COTE", "REILLY", "COMPTON", "RAYMOND", "MOONEY", "MCGOWAN", "CRAFT", "CLEVELAND", "CLEMONS", "WYNN",
            "NIELSEN", "BAIRD", "STANTON", "SNIDER", "ROSALES", "BRIGHT", "WITT", "STUART", "HAYS", "HOLDEN",
            "RUTLEDGE", "KINNEY", "CLEMENTS", "CASTANEDA", "SLATER", "HAHN", "EMERSON", "CONRAD", "BURKS", "DELANEY",
            "PATE", "LANCASTER", "SWEET", "JUSTICE", "TYSON", "SHARPE", "WHITFIELD", "TALLEY", "MACIAS", "IRWIN",
            "BURRIS", "RATLIFF", "MCCRAY", "MADDEN", "KAUFMAN", "BEACH", "GOFF", "CASH", "BOLTON", "MCFADDEN",
            "LEVINE", "GOOD", "BYERS", "KIRKLAND", "KIDD", "WORKMAN", "CARNEY", "DALE", "MCLEOD", "HOLCOMB", "ENGLAND",
            "FINCH", "HEAD", "BURT", "HENDRIX", "SOSA", "HANEY", "FRANKS", "SARGENT", "NIEVES", "DOWNS", "RASMUSSEN",
            "BIRD", "HEWITT", "LINDSAY", "LE", "FOREMAN", "VALENCIA", "ONEIL", "DELACRUZ", "VINSON", "DEJESUS", "HYDE",
            "FORBES", "GILLIAM", "GUTHRIE", "WOOTEN", "HUBER", "BARLOW", "BOYLE", "MCMAHON", "BUCKNER", "ROCHA",
            "PUCKETT", "LANGLEY", "KNOWLES", "COOKE", "VELAZQUEZ", "WHITLEY", "NOEL", "VANG");

    private static final RandomIntegerSupplier maleNameSelector = new RandomIntegerSupplier(firstMaleNames.size());
    private static final RandomIntegerSupplier femaleNameSelector = new RandomIntegerSupplier(firstFemaleNames.size());
    private static final RandomIntegerSupplier lastNameSelector = new RandomIntegerSupplier(lastNames.size());
    private static final RandomIntegerSupplier yearSelector = new RandomIntegerSupplier(15, 80);

    public static Supplier<String> maleNameSupplier = () -> firstMaleNames.get(maleNameSelector.get());
    public static Supplier<String> femaleNameSupplier = () -> firstFemaleNames.get(femaleNameSelector.get());
    public static Supplier<String> firstNameSupplier = () -> Double.compare(0.5, Math.random()) >= 0 ?
            maleNameSupplier.get() : femaleNameSupplier.get();
    public static Supplier<String> lastNameSupplier = () -> lastNames.get(lastNameSelector.get());
    private static final Supplier<String> userNameSupplier = () ->
            WordUtils.capitalizeFully(firstNameSupplier.get()) +
                    WordUtils.capitalizeFully(lastNameSupplier.get());

    private static final Function<String, String> uniqueNameSupplier = new Function<String, String>() {
        private HashSet<Integer> hashes = new HashSet<>();

        @Override
        public String apply(String s) {
            String name = s;
            String unique = name;
            while (hashes.contains(unique.hashCode())) {
                unique = name + yearSelector.get();
            }
            hashes.add(unique.hashCode());
            return unique;
        }
    };

    public static void main(String[] args) {

        Stream.generate(userNameSupplier).map(uniqueNameSupplier).limit(5000).forEach(System.out::println);

    }

}

