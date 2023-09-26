def solution(answers):
    
    student_score=[0,0,0]
    answer=[]
    
    s1=[1,2,3,4,5]
    s2=[2,1,2,3,2,4,2,5]
    s3=[3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        if answers[i] == s1[i%len(s1)]:
            student_score[0]+=1
        if answers[i] == s2[i%len(s2)]:
            student_score[1]+=1
        if answers[i] == s3[i%len(s3)]:
            student_score[2]+=1
    
    for student, score in enumerate(student_score):
        if score==max(student_score):
            answer.append(student+1)
            
    return answer