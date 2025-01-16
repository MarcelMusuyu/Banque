/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Convertion;

/**
 *
 * @author MARCEL
 */
public class Convertion {

    public static String conversion(int nombre) {

        if (nombre >= 0 && nombre <= 9) {
            return lettre1(nombre);
        } else if (nombre >= 10 && nombre <= 16) {
            return lettre2(nombre);
        } else if (nombre >= 17 && nombre <= 19) {
            return dizaine(nombre);
        } else if (nombre >= 20 && nombre <= 99) {
            return lettre3(nombre);
        } else if (nombre >= 100 && nombre <= 999) {
            return lettre4(nombre);
        } else if (nombre >= 1000 && nombre <= 9999) {
            return lettre5(nombre);
        } else if (nombre >= 10000 && nombre <= 99999) {
            return lettre6(nombre);
        } else if (nombre >= 100000 && nombre <= 999999) {
            return lettre7(nombre);

        } else {
            return lettre8(nombre);

        }
    }

    public static String lettre1(int chiffre) {
        String tab[] = {"zero", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf"};
        int i;
        for (i = 0; i < tab.length; i++) {
            if (chiffre == i) {
                return tab[i];
            }
        }
        return null;
    }

    public static String lettre2(int chiffre) {
        switch (chiffre) {
            case 10:
                return "Dix";
            case 11:
                return "Onze";
            case 12:
                return "Douze";
            case 13:
                return "Treize";
            case 14:
                return "Quatorze";
            case 15:
                return "Quinze";
            case 16:
                return "Seize";
            default:
                break;
        }
        return null;

    }

    public static String dizaine(int chiffre) {
        String dizaine[] = {"Dix"};
        int i;
        int nb = chiffre / 10;
        int nb1 = chiffre % 10;
        for (i = 0; i < dizaine.length; i++) {
            if (nb1 >= 7 && nb1 <= 9) {
                return dizaine[0] + " " + lettre1(nb1);
            }

        }
        return null;
    }

    public static String lettre3(int chiffre) {
        String dizaine[] = {"Vingt", "Trente", "Quanrante", "Cinquante", "Soixante", "Septente", "Quatre-vingt", "nonante"};
        int i;
        int nb = chiffre / 10;
        int nb1 = chiffre % 10;
        for (i = 0; i < dizaine.length; i++) {
            if (nb >= 2 && nb <= 9) {
                if (nb1 >= 0 && nb1 <= 9) {
                    if (nb1 == 0) {
                        return dizaine[nb - 2];
                    } else if (nb1 == 1) {
                        return dizaine[nb - 2] + " et " + lettre1(nb1);
                    }

                    return dizaine[nb - 2] + "-" + lettre1(nb1);
                }
            }
        }
        return null;
    }

    public static String lettre4(int chiffre) {
        String centaine[] = {"Cent", "Deux-cents", "Trois-cents", "Quatre-cents", "Cinq-cents", "Six-cents", "Sept-cents", "Huit-cents", "Neuf-cents"};
        int i;
        int nb1 = chiffre / 100;
        int nb2 = chiffre % 100;
        int nb3 = chiffre % 10;
        for (i = 0; i < centaine.length; i++) {
            if (nb1 >= 1 && nb1 <= 9) {
                if (nb2 >= 0 && nb2 <= 999) {
                    if (nb2 == 0) {
                        return centaine[nb1 - 1];
                    } else if (nb2 > 0 && nb2 <= 9) {
                        return centaine[nb1 - 1] + " et " + lettre1(nb2);
                    } else if (nb2 >= 10 && nb2 <= 16) {
                        return centaine[nb1 - 1] + " " + lettre2(nb2);
                    } else if (nb2 >= 17 && nb2 <= 19) {
                        return centaine[nb1 - 1] + " " + dizaine(nb2);
                    }
                    return centaine[nb1 - 1] + " " + lettre3(nb2);
                }
            }

        }
        return null;
    }

    public static String lettre5(int chiffre) {
        String mille[] = {"mille", "Deux-milles", "Trois-milles", "Quatre-milles", "Cinq-milles", "Six-milles", "Sept-milles", "Huit-milles", "Neuf-milles"};
        int i;
        int nb1 = chiffre / 1000;
        int nb2 = chiffre % 1000;
        for (i = 0; i < mille.length; i++) {
            if (nb1 >= 1 && nb1 <= 9) {
                if (nb2 >= 0 && nb2 <= 999) {
                    if (nb2 == 0) {
                        return mille[nb1 - 1];
                    } else if (nb2 >= 1 && nb2 <= 9) {
                        return mille[nb1 - 1] + " et " + lettre1(nb2);
                    } else if (nb2 >= 11 && nb2 <= 16) {
                        return mille[nb1 - 1] + " " + lettre2(nb2);
                    } else if (nb2 >= 17 && nb2 <= 19) {
                        return mille[nb1 - 1] + " " + dizaine(nb2);
                    } else if (nb2 >= 20 && nb2 <= 99) {
                        return mille[nb1 - 1] + " " + lettre3(nb2);
                    } else if (nb2 >= 100 && nb2 <= 999) {
                        return mille[nb1 - 1] + " " + lettre4(nb2);
                    }
                }
            }

        }
        return null;
    }

    public static String lettre6(int chiffre) {
        String dixmille[] = {"Dix-milles", "Vingt-milles", "Trente-milles", "Quarante-milles", "Cinquante-milles", "Soixante-milles", "Septente-milles", "Quatre-vingt-milles", "Nonante-milles"};
        String tab2[] = {"Onze-milles", "Douze-milles", "Treize-milles", "Quartoze-milles", "Quinze-milles", "Seize-milles", "Dix-sept-milles", "Dix-huit-milles", "Dix-neuf-milles"};
        int i;
        int nb1 = chiffre / 10000;
        int nb2 = chiffre % 10000;
        int nb3 = chiffre / 1000;
        int nb4 = chiffre % 1000;
        for (i = 0; i < dixmille.length; i++) {
            if (nb1 >= 1 && nb1 <= 9) {
                if (nb2 >= 0 && nb2 <= 9999) {
                    if (nb2 == 0) {
                        return dixmille[nb1 - 1];

                    } else if (nb3 >= 11 && nb3 <= 19) {
                        int val = chiffre % 1000;

                        if (val >= 100 && val <= 999) {
                            return tab2[nb3 - 11] + " " + lettre4(val);
                        } else if (val >= 20 && val <= 99) {

                            return tab2[nb3 - 11] + " " + lettre3(val);
                        } else if (val >= 10 && val <= 16) {
                            return tab2[nb3 - 11] + " " + lettre2(val);
                        } else if (val >= 17 && val <= 19) {
                            return tab2[nb3 - 11] + " " + dizaine(val);
                        }

                    } else if (nb2 >= 1 && nb2 <= 9) {
                        return dixmille[nb1 - 1] + " et " + lettre1(nb2);
                    } else if (nb2 >= 10 && nb2 <= 16) {
                        return dixmille[nb1 - 1] + " " + lettre2(nb2);
                    } else if (nb2 >= 17 && nb2 <= 19) {
                        return dixmille[nb1 - 1] + " " + dizaine(nb2);
                    } else if (nb2 >= 20 && nb2 <= 99) {
                        return dixmille[nb1 - 1] + " " + lettre3(nb2);
                    } else if (nb2 >= 100 && nb2 <= 999) {
                        return dixmille[nb1 - 1] + " " + lettre4(nb2);
                    } else if (nb2 >= 17 && nb2 <= 19) {
                        return dizaine(nb2) + dixmille[nb1 - 1];
                    } else if (nb3 >= 20 && nb3 <= 99) {
                        int val2 = chiffre % 1000;
                        if (val2 >= 100 && val2 <= 999) {
                            return lettre3(nb3) + " " + "milles" + " " + lettre4(val2);
                        } else if (val2 >= 20 && val2 <= 99) {
                            return lettre3(nb3) + " " + "milles" + " " + lettre3(val2);
                        } else if (val2 >= 10 && val2 <= 16) {
                            return lettre3(nb3) + " " + "milles" + " " + lettre2(val2);
                        } else if (val2 >= 17 && val2 <= 19) {
                            return lettre3(nb3) + " " + "milles" + " " + dizaine(val2);
                        }

                    }
                }

            }

        }

        for (i = 0; i < tab2.length; i++) {
            if (nb4 == 0) {
                int indice = (chiffre / 1000) % 10;
                int val = chiffre / 1000;
                if (val >= 11 && val <= 19) {
                    return tab2[indice - 1];
                } else if (val >= 20 && val <= 99) {
                    return lettre3(val) + " " + "milles";
                }
            }
        }

        return null;
    }

    public static String lettre7(int chiffre) {
        String centmille[] = {"Cent-milles", "Deux-cents-milles", "Trois-cents-milles", "Quatre-cents-milles", "Cinq-cents-milles", "Six-cents-milles", "Sep-cents-milles", "Huit-cents-milles", "Neuf-cents-milles"};
        int i;
        int nb1 = chiffre % 1000;
        int nb2 = chiffre / 1000;
        int nb3 = chiffre % 100000;
        int nb4 = chiffre / 100000;
        for (i = 0; i < centmille.length; i++) {
            if (nb4 >= 1 && nb4 <= 9) {
                if (nb3 >= 0 && nb3 <= 99999) {
                    if (nb3 == 0) {
                        return centmille[nb4 - 1];
                    } else if (nb3 >= 1 && nb3 <= 9) {
                        return centmille[nb4 - 1] + " et " + lettre1(nb3);
                    } else if (nb2 >= 100 && nb2 <= 999) {
                        int val = chiffre / 1000;
                        int val2 = chiffre % 1000;
                        if (val2 >= 100 && val2 <= 999) {
                            return lettre4(val) + " " + "milles" + " " + lettre4(val2);
                        } else if (val2 >= 20 && val2 <= 99) {
                            return lettre4(val) + " " + "milles" + " " + lettre3(val2);
                        } else if (val2 >= 10 && val2 <= 16) {
                            return lettre4(val) + " " + "milles" + " " + lettre2(val2);
                        } else if (val2 >= 17 && val2 <= 19) {
                            return lettre4(val) + " " + "milles" + " " + dizaine(val2);
                        } else if ((val >= 100 && val <= 999) && (val2 == 0)) {
                            return lettre4(val) + " " + "milles";
                        }

                    }

                }
            }

        }
        return null;
    }

    public static String lettre8(int chiffre) {
        String millions[] = {"Un-million", "Deux-millions", "Trois-millions", "Quatre-millions", "Cinq-millions", "Six-millions", "Sep-millions", "Huit-millions", "Neuf-millions"};
        int i;
        int nb1 = chiffre % 1000;
        int nb2 = chiffre / 1000;
        int nb3 = chiffre % 1000000;
        int nb4 = chiffre / 1000000;
        int nb5 = (chiffre / 1000) % 1000;
        for (i = 0; i < millions.length; i++) {
            if (nb4 >= 1 && nb4 <= 9) {
                if (nb3 >= 0 && nb3 <= 999999) {
                    if (nb3 == 0) {
                        return millions[nb4 - 1];
                    } else if (nb3 >= 1 && nb3 <= 9) {
                        return millions[nb4 - 1] + " et " + lettre1(nb3);

                    } else if (nb3 >= 100000 && nb3 <= 999999) {
                        return millions[nb4 - 1] + " " + lettre7(nb3);
                    } else if (nb3 >= 10000 && nb3 <= 99999) {
                        return millions[nb4 - 1] + " " + lettre6(nb3);
                    } else if (nb3 >= 1000 && nb3 <= 9999) {
                        return millions[nb4 - 1] + " " + lettre5(nb3);

                    }
                }

            }

        }
        return null;
    }

}
