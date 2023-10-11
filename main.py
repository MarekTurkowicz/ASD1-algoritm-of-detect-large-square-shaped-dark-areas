import random

def generate_data(filename, size):
    if size < 2:
        print("Rozmiar obrazu musi być większy niż 1.")
        return

    with open(filename, "w") as file:
        file.write(f"{size}\n")

        for i in range(size):
            row = ",".join([str(random.randint(0, 1)) for _ in range(size)])
            file.write(row + "\n")

        smaller_value = random.randint(1, size - 1)
        file.write(f"{smaller_value}\n")

    print(f"Plik {filename} został wygenerowany.")

generate_data("in3k.txt", 3000)
