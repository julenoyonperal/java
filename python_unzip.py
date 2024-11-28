import os
import zipfile

    
start_section = 12
end_section = 17
for section in range(start_section, end_section + 1):
    folder_name = f"section_{section}"
    root_folder = f"D:\\GitHub\\java\\{folder_name}\\"
    for folder_name, subfolders, filenames in os.walk(root_folder):
        for filename in filenames:
            #print(filename)
            # Check if the file is a zip file
            if filename.endswith('.zip'):
                file_path = os.path.join(folder_name, filename)
                extract_to = os.path.join(folder_name, filename[:-4])  # Remove .zip from folder name
                
                print(f"Extracting '{file_path}' to '{extract_to}'...")
                
                # Ensure the target extraction directory exists
                os.makedirs(extract_to, exist_ok=True)
                
                try:
                    with zipfile.ZipFile(file_path, 'r') as zip_ref:
                        zip_ref.extractall(extract_to)
                    print(f"Extracted successfully.")
                except zipfile.BadZipFile:
                    print(f"Error: '{file_path}' is not a valid zip file.")
                except Exception as e:
                    print(f"An error occurred while extracting '{file_path}': {e}")

# Set the root directory
root_folder = input("Enter the path of the folder to scan: ").strip()
extract_zip_files(root_folder)



import os

def create_section_folders(base_folder, start_section=13, end_section=40):
    

base_folder="D:\\GitHub\\java\\"
# Ensure the base folder exists
if not os.path.exists(base_folder):
    print(f"The base folder '{base_folder}' does not exist. Creating it...")
    os.makedirs(base_folder)

# Create folders for each section
start_section=12
end_section=40
for section in range(start_section, end_section + 1):
    folder_name = f"section_{section}"
    folder_path = os.path.join(base_folder, folder_name)
    try:
        os.makedirs(folder_path, exist_ok=True)  # Avoid errors if the folder already exists
        print(f"Created: {folder_path}")
    except Exception as e:
        print(f"Failed to create {folder_name}: {e}")

# Get the base folder path
base_folder = input("Enter the path of the base folder: ").strip()
create_section_folders(base_folder)
