# 스택 구현하기

# Create Stack
def create_stack():
    stack = []
    return stack


# 스택의 값이 비어있는지 확인
def check_empty(stack):
    return len(stack) == 0


# 스택에 푸쉬하기
def push(stack, item):
    stack.append(item)
    print(str(item) + ' is pushed')


# 스택에 팝하기
def pop(stack):
    if check_empty(stack):
        print('Stack is empty')

    return stack.pop()

stack = create_stack()
push(stack, 3)
push(stack,1)
push(stack,2)
print(stack)
pop(stack)
print(stack)