#Ransom note

#Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
#Each letter in the magazine string can only be used once in your ransom note.
#Note: You may assume that both strings contain only lowercase letters.

#Example:
#canConstruct("a", "b") -> false
#canConstruct("aa", "ab") -> false
#canConstruct("aa", "aab") -> true

var canConstruct = function(ransomNote, magazine) {
    var result = false;
    
    var hash = {};
    var negatives = {};
    
    if (magazine.length >= ransomNote.length) {
        for (var i=0; i<magazine.length; i++) {
            // Increment count for each magazine letter.
            hash[magazine[i]] = hash[magazine[i]] ? hash[magazine[i]] + 1 : 1;

            if (hash[magazine[i]] >= 0) {
                // This is a valid use of a letter.
                delete negatives[magazine[i]];
            }
            
            if (i < ransomNote.length) {
                // Decrement count for each used ransom note letter.
                hash[ransomNote[i]] = hash[ransomNote[i]] ? hash[ransomNote[i]] - 1 : -1;
                
                if (hash[ransomNote[i]] < 0) {
                    // This is a potential overuse of a letter.
                    negatives[ransomNote[i]] = 1;
                }
            }
        }
        
        result = Object.keys(negatives).length === 0;
    }
    
    return result;
};
