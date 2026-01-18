import pandas as pd

def fix_names(users: pd.DataFrame) -> pd.DataFrame:
    users['name'] = users['name'].str.lower()
    users['name'] = users['name'].str.capitalize()
    users = users.sort_values(by='user_id', ascending=True)

    return users

if __name__ == '__main__':
    data = {
        'user_id': [3, 1, 2],
        'name': ['aDAM', 'eWa', 'JAN']
    }
    users = pd.DataFrame(data)
    print(f"Przed fix_names(): {users}")
    result = fix_names(users)
    print(f"\nPo fix_names(): {result}")
