import os
import zipfile
import shutil

def unzip_files(path): 
    for folder_name, subfolders, filenames in os.walk(path):
        for filename in filenames:
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
                    
                    
import os

def remove_zip_files(path):
    for root, dirs, files in os.walk(path):
        for file in files:
            if file.endswith(".zip"):
                file_path = os.path.join(root, file)
                try:
                    os.remove(file_path)
                    print(f"Deleted: {file_path}")
                except Exception as e:
                    print(f"Failed to delete {file_path}: {e}")


path = "D:\\GitHub\\java\\"
for number in range(17, 44):
    full_path = f"{path}section_{number}"
    unzip_files(full_path)

for number in range(17, 44):
    full_path = f"{path}section_{number}"
    remove_zip_files(path)
    
                    
def move_pptx_files(path):
    # Create 'presentation' folder in the source directory
    presentation_folder = os.path.join(path, "presentations")
    if not os.path.exists(presentation_folder):
        os.mkdir(presentation_folder)
        print(f"Folder 'presentations' created at {presentation_folder}")
    else:
        print(f"Folder 'presentations' already exists.")

    # Loop through files in the source directory
    for filename in os.listdir(path):
        if filename.endswith(".pptx"):
            source_path = os.path.join(path, filename)
            destination_path = os.path.join(presentation_folder, filename)
            # Move the file
            shutil.move(source_path, destination_path)
            print(f"Moved: {filename}")
    
    print("All .pptx files have been moved.")

for number in range(17, 44):
    full_path = f"{path}section_{number}"
    move_pptx_files(full_path)

def remove_string_from_filenames(path, string_to_remove):
    try:
        # Get the list of all files in the folder
        files = os.listdir(path)

        # Iterate through the files
        for filename in files:
            # Check if the string_to_remove is in the filename
            if string_to_remove in filename:
                # Create the new filename by replacing the string
                new_filename = filename.replace(string_to_remove, "")
                # Get the full path for the old and new filenames
                old_path = os.path.join(path, filename)
                new_path = os.path.join(path, new_filename)
                # Rename the file
                os.rename(old_path, new_path)
                print(f"Renamed: {filename} -> {new_filename}")
        
        print("All matching files have been renamed.")
    
    except Exception as e:
        print(f"An error occurred: {e}")

# Example usage
path = "D:\\GitHub\\java\\section_16\\presentations\\"    # Replace with the path to your folder
string_to_remove = "Source-code-Arrays-"  # Replace with the string
remove_string_from_filenames(path, string_to_remove)


import os

def remove_string_from_folder_names(path, string_to_remove):
    try:
        # Get the list of all folders in the directory
        items = os.listdir(path)
        
        for item in items:
            # Create the full path for the item
            item_path = os.path.join(path, item)
            
            # Check if the item is a folder and contains the string_to_remove
            if os.path.isdir(item_path) and string_to_remove in item:
                # Create the new folder name
                new_folder_name = item.replace(string_to_remove, "")
                new_folder_path = os.path.join(path, new_folder_name)
                
                # Rename the folder
                os.rename(item_path, new_folder_path)
                print(f"Renamed: {item} -> {new_folder_name}")
        
        print("All matching folders have been renamed.")
    
    except Exception as e:
        print(f"An error occurred: {e}")
i = 30
# Example usage
i = i + 1
path = f"D:\\GitHub\\java\\section_{i}\\"
string_to_remove = "Java-Networking-"  
remove_string_from_folder_names(path, string_to_remove)
