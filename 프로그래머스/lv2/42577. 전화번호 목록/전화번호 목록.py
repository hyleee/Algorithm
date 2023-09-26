def solution(phone_book):
    hashmap={}
    
    for phone_number in phone_book:
        hashmap[phone_number]=1
        
    for phone_number in phone_book:
        jubdoo=""
        for number in phone_number:
            jubdoo+=number
            if jubdoo in hashmap and jubdoo!=phone_number:
                return False
    return True
            