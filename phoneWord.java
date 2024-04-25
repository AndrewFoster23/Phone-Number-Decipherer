import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class phoneWord{
  private static int count = 0;
  // private static ArrayList<String> sevens = new ArrayList<>(Arrays.asList(
  // "ability", "backing", "cabinet"));

  private static ArrayList<String> sevens = new ArrayList<>();



  // System.out.println(sevens.get(0));

  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    // wordOrganize list = new wordOrganize();
    // sevens = wordOrganize.organize();
    BufferedReader reader = new BufferedReader(new FileReader("words.txt"));

    while(true){
      String currentLine = reader.readLine();
      if(currentLine == null){
        break;
      }
      sevens.add(currentLine.substring(0,7).toLowerCase());
      sevens.add(currentLine.substring(8,15).toLowerCase());
      sevens.add(currentLine.substring(16,23).toLowerCase());

    }

    reader.close();

    while(true){
      System.out.println("Enter a seven digit phone number: ");
      int number = input.nextInt();

      if(number < 1000000 || number > 9999999){
        continue;
      }

      int finalNumber = number;

      ArrayList<Integer> nums = new ArrayList<>(7);

      for(int i = 0; i < 7; i++){
        if(number % 10 >= 2){
          nums.add(0, number % 10);
        }
        number /= 10;
      }
      if(nums.size() == 7){
        String word = findWordV2(finalNumber);

        if(word != ""){
          System.out.println("Your phone number translates to the word " + word);
        }else{
          System.out.println("Your phone number does not translate to any known words");
        }

        break;
      }
      System.out.println("You cannot input a number with zeroes or ones.");
    }


  }

  public static String findWordV2(int number){
    String word = "";


    ArrayList<Integer> nums = new ArrayList<>(7);

    for(int i = 0; i < 7; i++){
      nums.add(0, number % 10);
      number /= 10;
    }

    // ArrayList[][] list = {}

    return buildWord("", nums);


  }

  public static String buildWord(String fortnite, ArrayList<Integer> nums){
    String word = fortnite;
    String answer = "";
    int length = word.length();



    ArrayList<String> two = new ArrayList<>(Arrays.asList(
    "a", "b", "c"));

    ArrayList<String> three = new ArrayList<>(Arrays.asList(
    "d", "e", "f"));

    ArrayList<String> four = new ArrayList<>(Arrays.asList(
    "g", "h", "i"));

    ArrayList<String> five = new ArrayList<>(Arrays.asList(
    "j", "k", "l"));

    ArrayList<String> six = new ArrayList<>(Arrays.asList(
    "m", "n", "o"));

    ArrayList<String> seven = new ArrayList<>(Arrays.asList(
    "p", "r", "s"));

    ArrayList<String> eight = new ArrayList<>(Arrays.asList(
    "t", "u", "v"));

    ArrayList<String> nine = new ArrayList<>(Arrays.asList(
    "w", "x", "y"));



    for(int a = 0; a < 3; a++){
      word = word.substring(0, length);

      if(nums.get(length) == 2){
        word += two.get(a);
      }else if(nums.get(length) == 3){
        word += three.get(a);
      }else if(nums.get(length) == 4){
        word += four.get(a);
      }else if(nums.get(length) == 5){
        word += five.get(a);
      }else if(nums.get(length) == 6){
        word += six.get(a);
      }else if(nums.get(length) == 7){
        word += seven.get(a);
      }else if(nums.get(length) == 8){
        word += eight.get(a);
      }else if(nums.get(length) == 9){
        word += nine.get(a);
      }

      if(word.length() == 7){
        for(String wordList : sevens){
          if(wordList.equals(word)){
            return word;
          }
        }
      }else{
        answer = buildWord(word, nums);
        if(answer.length() != 0){
          return answer;
        }
      }
    }

    return "";
  }



  public static String findWord(int number){
    // boolean fortnite = true;
    String answer = "";

    ArrayList<Integer> nums = new ArrayList<>(7);

    ArrayList<String> two = new ArrayList<>(Arrays.asList(
    "a", "b", "c"));

    ArrayList<String> three = new ArrayList<>(Arrays.asList(
    "d", "e", "f"));

    ArrayList<String> four = new ArrayList<>(Arrays.asList(
    "g", "h", "i"));

    ArrayList<String> five = new ArrayList<>(Arrays.asList(
    "j", "k", "l"));

    ArrayList<String> six = new ArrayList<>(Arrays.asList(
    "m", "n", "o"));

    ArrayList<String> seven = new ArrayList<>(Arrays.asList(
    "p", "r", "s"));

    ArrayList<String> eight = new ArrayList<>(Arrays.asList(
    "t", "u", "v"));

    ArrayList<String> nine = new ArrayList<>(Arrays.asList(
    "w", "x", "y"));



    for(int i = 0; i < 7; i++){
      nums.add(0, number % 10);
      number /= 10;
    }


    for(int a = 0; a < 3; a++){

      answer = "";


      if(nums.get(0) == 2){
        answer += two.get(a);
      }else if(nums.get(0) == 3){
        answer += three.get(a);
      }else if(nums.get(0) == 4){
        answer += four.get(a);
      }else if(nums.get(0) == 5){
        answer += five.get(a);
      }else if(nums.get(0) == 6){
        answer += six.get(a);
      }else if(nums.get(0) == 7){
        answer += seven.get(a);
      }else if(nums.get(0) == 8){
        answer += eight.get(a);
      }else if(nums.get(0) == 9){
        answer += nine.get(a);
      }

      for(int b = 0; b < 3; b++){

        answer = answer.substring(0, 1);

        if(nums.get(1) == 2){
          answer += two.get(b);
        }else if(nums.get(1) == 3){
          answer += three.get(b);
        }else if(nums.get(1) == 4){
          answer += four.get(b);
        }else if(nums.get(1) == 5){
          answer += five.get(b);
        }else if(nums.get(1) == 6){
          answer += six.get(b);
        }else if(nums.get(1) == 7){
          answer += seven.get(b);
        }else if(nums.get(1) == 8){
          answer += eight.get(b);
        }else if(nums.get(1) == 9){
          answer += nine.get(b);
        }

        for(int c = 0; c < 3; c++){

          answer = answer.substring(0, 2);

          if(nums.get(2) == 2){
            answer += two.get(c);
          }else if(nums.get(2) == 3){
            answer += three.get(c);
          }else if(nums.get(2) == 4){
            answer += four.get(c);
          }else if(nums.get(2) == 5){
            answer += five.get(c);
          }else if(nums.get(2) == 6){
            answer += six.get(c);
          }else if(nums.get(2) == 7){
            answer += seven.get(c);
          }else if(nums.get(2) == 8){
            answer += eight.get(c);
          }else if(nums.get(2) == 9){
            answer += nine.get(c);
          }

          for(int d = 0; d < 3; d++){

            answer = answer.substring(0, 3);

            if(nums.get(3) == 2){
              answer += two.get(d);
            }else if(nums.get(3) == 3){
              answer += three.get(d);
            }else if(nums.get(3) == 4){
              answer += four.get(d);
            }else if(nums.get(3) == 5){
              answer += five.get(d);
            }else if(nums.get(3) == 6){
              answer += six.get(d);
            }else if(nums.get(3) == 7){
              answer += seven.get(d);
            }else if(nums.get(3) == 8){
              answer += eight.get(d);
            }else if(nums.get(3) == 9){
              answer += nine.get(d);
            }

            for(int e = 0; e < 3; e++){

              answer = answer.substring(0, 4);

              if(nums.get(4) == 2){
                answer += two.get(e);
              }else if(nums.get(4) == 3){
                answer += three.get(e);
              }else if(nums.get(4) == 4){
                answer += four.get(e);
              }else if(nums.get(4) == 5){
                answer += five.get(e);
              }else if(nums.get(4) == 6){
                answer += six.get(e);
              }else if(nums.get(4) == 7){
                answer += seven.get(e);
              }else if(nums.get(4) == 8){
                answer += eight.get(e);
              }else if(nums.get(4) == 9){
                answer += nine.get(e);
              }

              for(int f = 0; f < 3; f++){

                answer = answer.substring(0, 5);

                if(nums.get(5) == 2){
                  answer += two.get(f);
                }else if(nums.get(5) == 3){
                  answer += three.get(f);
                }else if(nums.get(5) == 4){
                  answer += four.get(f);
                }else if(nums.get(5) == 5){
                  answer += five.get(f);
                }else if(nums.get(5) == 6){
                  answer += six.get(f);
                }else if(nums.get(5) == 7){
                  answer += seven.get(f);
                }else if(nums.get(5) == 8){
                  answer += eight.get(f);
                }else if(nums.get(5) == 9){
                  answer += nine.get(f);
                }

                for(int g = 0; g < 3; g++){

                  answer = answer.substring(0, 6);

                  if(nums.get(6) == 2){
                    answer += two.get(g);
                  }else if(nums.get(6) == 3){
                    answer += three.get(g);
                  }else if(nums.get(6) == 4){
                    answer += four.get(g);
                  }else if(nums.get(6) == 5){
                    answer += five.get(g);
                  }else if(nums.get(6) == 6){
                    answer += six.get(g);
                  }else if(nums.get(6) == 7){
                    answer += seven.get(g);
                  }else if(nums.get(6) == 8){
                    answer += eight.get(g);
                  }else if(nums.get(6) == 9){
                    answer += nine.get(g);
                  }



                  // System.out.println(answer);

                  for(String wordList : sevens){
                    if(wordList.equals(answer)){
                      return answer;
                    }
                  }

                  }
                }
              }
            }
          }
        }
      }


    return "";
  }





}
