import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private static List<Animals> animalsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Завести новое животное");
            System.out.println("2. Увидеть список команд животного");
            System.out.println("3. Обучить животное новым командам");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Выберите тип животного (1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел): ");
                    int type = scanner.nextInt();
                    try (Counter counter = new Counter()) {
                        switch (type) {
                            case 1:
                                animalsList.add(new Dogs(name));
                                break;
                            case 2:
                                animalsList.add(new Cats(name));
                                break;
                            case 3:
                                animalsList.add(new Hamsters(name));
                                break;
                            case 4:
                                animalsList.add(new Horses(name));
                                break;
                            case 5:
                                animalsList.add(new Camels(name));
                                break;
                            case 6:
                                animalsList.add(new Donkeys(name));
                                break;
                            default:
                                System.out.println("Некорректный тип животного.");
                        }
                        counter.add(); // Увеличиваем счетчик
                        System.out.println("Животное добавлено. Всего животных: " + counter.getCount());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Введите имя животного для просмотра команд: ");
                    String animalName = scanner.nextLine();
                    for (Animals animal : animalsList) {
                        if (animal.getName().equalsIgnoreCase(animalName)) {
                            System.out.println("Команды для " + animal.getName() + ": ");
                            for (String command : animal.getCommands()) {
                                System.out.println(command);
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Введите имя животного для обучения: ");
                    String trainAnimalName = scanner.nextLine();
                    System.out.print("Введите новую команду: ");
                    String newCommand = scanner.nextLine();
                    for (Animals animal : animalsList) {
                        if (animal.getName().equalsIgnoreCase(trainAnimalName)) {
                            animal.train(newCommand);
                            System.out.println(animal.getName() + " обучен новой команде: " + newCommand);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите еще раз.");
            }
        }
    }
}