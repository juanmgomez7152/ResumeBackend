from open_ai_conn import openai_call

class OpenAiSession:
    def __init__(self, api_key):
        history = []
        
    async def send_message(self, message):
        self.history.append(message)
        
        return await openai_call(self.history) 
