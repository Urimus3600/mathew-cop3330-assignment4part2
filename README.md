# mathew-cop3330-assignment4part2
Hello!
You're here because you're interested in my application, if its not too much to assume.

The top 3 buttons are for addition and deletion of items.
1. Add Item - this will take whatever is currently within the description and date and create a new item and add it to the list
            - changes to the complete box will not be noted, but will affect the previous item
            - the new item's completeness is set to incomplete
            - this will open the new created item in the item display and refresh the table display
2. Remove Item - will remove current displayed item based on the index
               - will refresh the display
3. Clear All - removes all items
             - also refreshes display
             
The left hand side has buttons for affecting the entire todolist.
Filter - this section is for choosing which items will show in the display
    Complete - if checked only completed tasks will appear
    Incomplete - if checked only incompleted tasks will appear
Load File - not working atm but should receive a todolist in a specific format from a specific file
Save to File - should write to the same default file as Load File, writes in the specified format to store the current todolist

The right hand side is the item display which always for viewing and editing of items.
1. Choose Item - sets the item display to display and edit the file of the ID in the text field to its right
2. Replace Date - takes Date in text field and places it in the current item
3. Replace Description - takes current Description in text field and places it in the item
4. Enter - replaces both date and description with current textfields
5. Complete - is checked to display completeness, toggles from complete to incomplete  
