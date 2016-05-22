read -p "Commit Message: " message
git add *
git commit -a -m $message
git push origin master
echo Upload erfolgreich.
read -p "Press [Enter] key to finish..."